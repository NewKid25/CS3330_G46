package services;

import java.util.Comparator;

import models.Pet;

public class PetComparatorByAge implements Comparator<Pet>{

    /**
     * Compares two Pet objects based on their age.
     *
     * @param p1 the first Pet to compare
     * @param p2 the second Pet to compare
     * @return a negative integer, zero, or a positive integer if the first pet is younger than, 
     *         the same age as, or older than the second pet
     */
	@Override
	public int compare(Pet p1, Pet p2) {

		return p1.getAge()-p2.getAge();
	}

}
