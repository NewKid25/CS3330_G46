package services;

import java.util.Comparator;

import models.Pet;

public class PetComparatorByType implements Comparator<Pet>{

    /**
     * Compares two Pet objects based on their names.
     *
     * @param p1 the first Pet to compare
     * @param p2 the second Pet to compare
     * @return a negative integer, zero, or a positive integer if the first pet's type comes lexicographically first, 
     *         is the same as, or after the second pet's name
     */
	@Override
	public int compare(Pet p1, Pet p2) {

		return p1.getType().compareTo(p2.getType());
	}

}
