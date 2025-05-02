package services;

import java.util.Comparator;

import models.Pet;

public class PetComparatorByAge implements Comparator<Pet>{

	@Override
	public int compare(Pet p1, Pet p2) {

		return p1.getAge()-p2.getAge();
	}

}
