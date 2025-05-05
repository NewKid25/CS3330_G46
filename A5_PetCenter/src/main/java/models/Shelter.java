package models;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Pet> {
	
	ArrayList<T> petList= new ArrayList<T>();
	/**
	 * adds a pet to the list
	 * @param pet: new pet by user
	 */
	public void AddPet(T pet)
	{
		petList.add(pet);
	}
	/**
	 * adds multiple pets to the list
	 * @param pet: multiple new pet by user
	 */
	public void AddPets(List<T> pets)
	{
		for(var pet : pets)
		{
			AddPet(pet);
		}
	}
	/**
	 * to String for pet list
	 */
	@Override
	public String toString() {
		return "Shelter [petList=" + petList + "]";
	}
	
	
}
