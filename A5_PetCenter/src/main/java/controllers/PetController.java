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
import services.PetComparatorByAge;
import services.PetComparatorById;
import services.PetComparatorBySpecies;
import services.PetComparatorByType;
import services.PetJsonParser;
import views.*;

public class PetController {
	private PetView view;
	private ArrayList<Pet> pets;

	/**
	 * adds parser and reads in the animals
	 */
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
	
	/**
	 * adds action listeners to all gui items
	 */
	private void addActionListenersToView()
	{
		view.addActionListenerToAddButton(new AddButtonActionListener(this));
		view.addActionListenerToRemoveButton(new RemoveButtonActionListener());
		view.addActionListenerToAdoptButton(new AdoptButtonActionListener());
		view.addActionListenerToDetailsButton(new DetailsButtonActionListener());
		view.addActionListenerToSaveButton(new SaveButtonActionListener());
		view.addActionListenerToComboBox(new ComboBoxActionListener());
	}
	
	
	
	/**
	 * makes the add button pull up the add new pet screen
	 */
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
	/**
	 * adopts pet when click on button
	 */
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
	/**
	 * removes pet from list when remove button clicked
	 */
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
	/**
	 * opens up details window when details button clicked
	 */
	private class DetailsButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {

			int[] petIndices = view.getSelectedPetsIndices();
			new PetDetailsController(pets.get(petIndices[0])); //if multiple pets selected only get first one
			

			
		}
		
	}
	/**
	 * sorts the list based on which dropdown index
	 */
	private class ComboBoxActionListener implements ActionListener{

		private static final int Comparator = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			var sortType = view.getSelectedSortType();
			
			if(sortType.equalsIgnoreCase("name")) {
				pets.sort(null); //use comparable method
			}
			else if(sortType.equalsIgnoreCase("age")) {
				pets.sort(new PetComparatorByAge());
			}
			else if(sortType.equalsIgnoreCase("species")) {
				pets.sort(new PetComparatorBySpecies());
			}
			else if(sortType.equalsIgnoreCase("type")) {
				pets.sort(new PetComparatorByType());
			}
			else if(sortType.equalsIgnoreCase("id")) {
				pets.sort(new PetComparatorById());
			}
			else {
				new ErrorMessageView("Invalid sort attempted");
			}
			view.setPetList(pets);
		}
		
	}
	/**
	 * Saves to another json file when save button clicked
	 */
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			var parser = new PetJsonParser();
			parser.WritePetsToFile(pets, "./src/main/resources/");
			
		}
		
	}
	/**
	 * adds a pet to the list
	 * @param pet: pet given by user
	 */
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
