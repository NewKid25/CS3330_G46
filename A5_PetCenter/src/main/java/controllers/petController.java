package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ExoticAnimal;
import models.NormalAnimal;
import views.PetDetailsView;
import views.PetView;

public class petController {
	private PetView view;
	private ExoticAnimal exanimal;
	private NormalAnimal normanimal;
	
	public petController(PetView view, ExoticAnimal exanimal, NormalAnimal normanimal) {
		super();
		this.view = view;
		this.exanimal = exanimal;
		this.normanimal = normanimal;
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
