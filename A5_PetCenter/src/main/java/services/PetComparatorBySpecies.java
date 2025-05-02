package services;

import java.util.Comparator;

import models.Pet;

public class PetComparatorBySpecies implements Comparator<Pet>{

	@Override
	public int compare(Pet p1, Pet p2) {

		return p1.getSpecies().compareTo(p2.getSpecies());
	}

}
