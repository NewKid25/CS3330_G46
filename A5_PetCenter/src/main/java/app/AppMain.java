package app;

import services.*;
import views.*;
import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controllers.PetController;



public class AppMain {

	public static void main(String[] args) {

		
		var controller = new PetController();
		
//		var bob = new PetJsonParser();
//		var pets = bob.ReadNormalAnimals("./src/main/resources/pets.json");
//		var pets2 = new ArrayList<Pet>();
//		var shelter = new Shelter<NormalAnimal>();
//		
//		for(var a : pets)
//		{
//			System.out.println(a.toString());
//			pets2.add(a);
//		}
//		
//		var view = new PetView(pets2);
////		Collections.sort(pets, new PetComparatorBySpecies());
//		Collections.sort(pets);
//
//		System.out.println(pets);
//		
//		Collections.sort(pets, Collections.reverseOrder());
//		
//		System.out.println(pets);

		
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
