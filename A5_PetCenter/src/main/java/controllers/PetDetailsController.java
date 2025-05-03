package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.NormalAnimal;
import models.Pet;
import views.ErrorMessageView;
import views.PetDetailsView;

public class PetDetailsController {
	private PetDetailsView view;
	private PetController petController = null;
	
	public PetDetailsController(PetController controller)
	{
		view = new PetDetailsView(null, true);
		petController = controller;
		addActionListenersToView();
	}
	
	public PetDetailsController(Pet pet)
	{
		view = new PetDetailsView(pet, false);
		addActionListenersToView();
	}
	
	private void addActionListenersToView()
	{
		if(petController != null)
		{			
			view.addActionListenerToSubmitButton(new SubmitButtonActionListener());
		}
	}
	
	private class SubmitButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(petController != null)
			{
				
				int id, age;
				try
				{
					id = Integer.parseInt(view.getPetID());
					age = Integer.parseInt(view.getPetAge());

				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
					new ErrorMessageView("Invalid input. ID and Age only accept integers");
					return;
				}
				
				var normalAnimal = new NormalAnimal(id, view.getPetName(), view.getPetType(), view.getPetSpecies(), age);
				
				petController.addPet(normalAnimal);
			}
		}
		
	}
}
