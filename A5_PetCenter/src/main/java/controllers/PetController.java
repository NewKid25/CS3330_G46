package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComboBox;

import models.NormalAnimal;
import models.Pet;
import models.Shelter;
import services.PetJsonParser;
import views.*;

public class PetController {
	private PetView view;
	private ArrayList<Pet> pets;

	
	public PetController() {
		super();
		
		var parser = new PetJsonParser();
		var normalAnimals = parser.ReadNormalAnimals("./src/main/resources/pets.json");
		var exoticAnimals = parser.ReadExoticAnimals("./src/main/resources/exotic_animals.json");

		pets = new ArrayList<Pet>();
//		var shelter = new Shelter<NormalAnimal>();
		
		for(var a : normalAnimals)
		{
			pets.add(a);
		}
		for(var a : exoticAnimals)
		{
			pets.add(a);
		}
		
		view = new PetView(pets);
		
		addActionListenersToView();
		
	}
	
	
	private void addActionListenersToView()
	{
		view.addActionListenerToAddButton(new AddButtonActionListener(this));
		view.addActionListenerToRemoveButton(new RemoveButtonActionListener());
		view.addActionListenerToAdoptButton(new AdoptButtonActionListener());
		view.addActionListenerToDetailsButton(new DetailsButtonActionListener());
		view.addActionListenerToSaveButton(new SaveButtonActionListener());
		view.addActionListenerToComboBox(new ComboBoxActionListener());
	}
	
	
	
	
	private class AddButtonActionListener implements ActionListener{

		private PetController parent;
		public AddButtonActionListener(PetController controller)
		{
			parent = controller;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new PetDetailsController(parent);
			
		}
		
	}
	private class AdoptButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			int[] petIndices = view.getSelectedPetsIndices();
			String errorMsg = "";
			for(var index : petIndices)
			{
				var petToAdopt = pets.get(index);
				if(petToAdopt.isAdopted())
				{
					errorMsg += petToAdopt.getName() + " is already adopted.\n";
				}
				else
				{					
					pets.get(index).setAdopted(true);
				}
			}
			view.setPetList(pets);
			if(!errorMsg.isEmpty())
			{
				errorMsg += "Pets that are already adopted cannot be adopted again.";
				new ErrorMessageView(errorMsg);
			}
		}
		
	}
	private class RemoveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {			
			
			int[] petIndices = view.getSelectedPetsIndices();
			
			//indices will be in ascending order, so go through them in reverse (so no problems with index changing after removal)
			for(int i = petIndices.length-1; i>=0; i--) 
			{
				pets.remove(petIndices[i]);
			}
			
			view.setPetList(pets);
			
		}
		
	}
	private class DetailsButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {

			int[] petIndices = view.getSelectedPetsIndices();
			new PetDetailsController(pets.get(petIndices[0])); //if multiple pets selected only get first one
			

			
		}
		
	}
	
	private class ComboBoxActionListener implements ActionListener{

		private static final int Comparator = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] dropdown = {"Sort by","id", "name", "type", "species", "age"};
			JComboBox p = new JComboBox(dropdown);
			
			if(p.getSelectedIndex() == 0) {
				pets.sort(null);
			}
			else if(p.getSelectedIndex() == 1) {
				pets.sort(null);
			}
			else if(p.getSelectedIndex() == 2) {
				pets.sort(null);
			}
			else if(p.getSelectedIndex() == 3) {
				pets.sort(null);
			}
			else if(p.getSelectedIndex() == 4) {
				pets.sort(null);
			}
			else {
				new ErrorMessageView("Invalid ");
			}
			
		}
		
	}
	
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			var parser = new PetJsonParser();
			parser.WritePetsToFile(pets, "./src/main/resources/");
			
		}
		
	}
	public void addPet(Pet pet) {
		for(var p : pets)
		{
			if(p.getId() == pet.getId())
			{
				new ErrorMessageView("Pet with ID "+pet.getId()+" already exists, and cannot be added");
				return;
			}
		}
		//if pet has unique ID, add it to the list
		pets.add(pet);
		view.setPetList(pets);
	}
	
}
