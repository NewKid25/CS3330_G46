package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ExoticAnimal;
import models.NormalAnimal;
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
			//add new user here using button
			
		}
		
	}
	private class DeleteButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//delete new user here using button
			
		}
		
	}
	private class DetailsButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//view animal details closer up here
			
		}
		
	}
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//Save action implemented here
			
		}
		
	}
	
}
