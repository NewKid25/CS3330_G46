package controllers;

import models.Pet;
import views.PetDetailsView;

public class PetDetailsController {
	private PetDetailsView view;
	
	public PetDetailsController()
	{
		view = new PetDetailsView(null, true);
	}
	
	public PetDetailsController(Pet pet)
	{
		view = new PetDetailsView(pet, false);
	}
}
