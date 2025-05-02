package app;

import services.*;
import views.*;
import models.*; 

import java.util.Collections;



public class AppMain {

	public static void main(String[] args) {

		var bob = new PetJsonParser();
		var pets = bob.ReadNormalAnimals("./src/main/resources/pets.json");
		var shelter = new Shelter<NormalAnimal>();
		
		for(var a : pets)
		{
			System.out.println(a.toString());
		}
		
//		Collections.sort(pets, new PetComparatorBySpecies());
		Collections.sort(pets);

		System.out.println(pets);
		
		Collections.sort(pets, Collections.reverseOrder());
		
		System.out.println(pets);

		
//		shelter.AddPets(pets);
//		System.out.println(shelter);
		
//		var pets1 = bob.ReadExoticAnimals("./src/main/resources/exotic_animals.json");
//		
//		for(var a : pets1)
//		{
//			System.out.println(a.toString());
//		}

	}

}
