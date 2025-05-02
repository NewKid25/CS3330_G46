package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.ExoticAnimal;
import models.NormalAnimal;
import models.Pet;
import models.Shelter;
import services.PetJsonParser;
import views.PetDetailsView;
import views.PetView;

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
		
		view.addActionListenerToRemoveButton(new DeleteButtonActionListener());
	}
	
	private class AdoptButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("hello");
			PetView petview = new PetView(pets);
			int index = petview.adoptList.getSelectedIndex();
			petview.adoptedList.addSelectionInterval(0, index); //add to adoptedlist?
		}
		
	}
	private class DeleteButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			PetView petview = new PetView(pets);
			int index = petview.adoptList.getSelectedIndex();
			petview.adoptList.remove(index);
		}
		
	}
	private class DetailsButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("hello");
			PetDetailsView petview2 = new PetDetailsView();
			petview2.initiate();
			
		}
		
	}
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("hello");
			//Save adopted animals to json file button implemented here
			
		}
		
	}
	public int getPetDetails(Pet pet) {
		PetDetailsView petview = new PetDetailsView();
		petview.petName.setText(pet.getName());
		//petview.petID.setText(pet.getId()); trouble with casting id to strings.
		petview.petSpecies.setText(pet.getSpecies());
		petview.petType.setText(pet.getType());
		//petviewpetAge.setText(pet.getAge()); trouble with casting age to strings.
		return 0;
	}
	
}
