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

	
	public PetController() {
		super();
		
		var parser = new PetJsonParser();
		var normalAnimals = parser.ReadNormalAnimals("./src/main/resources/pets.json");
		var exoticAnimals = parser.ReadExoticAnimals("./src/main/resources/exotic_animals.json");

		var pets = new ArrayList<Pet>();
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
	}
	
	private class AdoptButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			PetView currentview = new PetView();
//			if(arg0 == exanimal) {
//				currentview.adoptList.add(exanimal.getName(), currentview.adoptList);
//			}
//			currentview.adoptList.add(normanimal.getName(), currentview.adoptList);
			
		}
		
	}
	private class DeleteButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			PetView currentview = new PetView();
//			if(arg0 == exanimal) {
//				currentview.adoptList.removeElement(exanimal.getName(), currentview.adoptList);
//			}
//			currentview.adoptList.removeElement(normanimal.getName(), currentview.adoptList);
//			
		}
		
	}
	private class DetailsButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			PetDetailsView newview = new PetDetailsView();
//			newview.getPetDetails();
//			newview.isVisible(true);
		}
		
	}
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Save adopted animals to json file button implemented here
			
		}
		
	}
	
}
