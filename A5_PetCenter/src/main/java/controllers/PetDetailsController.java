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
	
	/**
	 * Opens up the new window with a controller
	 * @param controller
	 */
	public PetDetailsController(PetController controller)
	{
		view = new PetDetailsView(null, true);
		petController = controller;
		addActionListenersToView();
	}
	/**
	 * Shows the details of a certain pet selected
	 * @param pet: pet selected by user
	 */
	public PetDetailsController(Pet pet)
	{
		view = new PetDetailsView(pet, false);
		addActionListenersToView();
	}
	/**
	 * adds action listener to submit button
	 */
	private void addActionListenersToView()
	{
		if(petController != null)
		{			
			view.addActionListenerToSubmitButton(new SubmitButtonActionListener());
		}
	}
	/**
	 * Submits a new pet to the list when button clicked.
	 */
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
				
				String name = view.getPetName();
				String type = view.getPetType();
				String species = view.getPetSpecies();

				
				if(name.isEmpty() || type.isEmpty() || species.isEmpty())
				{
					new ErrorMessageView("Invalid input. All input fields need to filled in with at least one character");
					return;
				}
				
				var normalAnimal = new NormalAnimal(id, name, type, species, age);
				
				petController.addPet(normalAnimal);
			}
		}
		
	}
}
