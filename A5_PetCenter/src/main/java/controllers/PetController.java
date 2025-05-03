package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.ExoticAnimal;
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
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(arg0);

			System.out.println("hello");
			//Save adopted animals to json file button implemented here
			
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
