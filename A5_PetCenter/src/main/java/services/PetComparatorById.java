package services;

import java.util.Comparator;

import models.Pet;

public class PetComparatorById implements Comparator<Pet>{

    /**
     * Compares two Pet objects based on their age.
     *
     * @param p1 the first Pet to compare
     * @param p2 the second Pet to compare
     * @return a negative integer, zero, or a positive integer if the first pet's id is less than, 
     *         the equal to, or more than the second pet
     */
	@Override
	public int compare(Pet p1, Pet p2) {

		return p1.getId()-p2.getId();
	}

}
