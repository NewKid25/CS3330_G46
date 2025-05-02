package models;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Pet> {
	
	ArrayList<T> petList= new ArrayList<T>();

	public void AddPet(T pet)
	{
		petList.add(pet);
	}
	
	public void AddPets(List<T> pets)
	{
		for(var pet : pets)
		{
			AddPet(pet);
		}
	}

	@Override
	public String toString() {
		return "Shelter [petList=" + petList + "]";
	}
	
	
}
