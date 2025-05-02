package app;

import services.*;
import views.*;
import models.*;


public class AppMain {

	public static void main(String[] args) {

		var bob = new PetJsonParser();
		var pets = bob.ReadNormalAnimals("./src/main/resources/pets.json");
		
		for(var a : pets)
		{
			System.out.println(a.toString());
		}
		
		var pets1 = bob.ReadExoticAnimals("./src/main/resources/exotic_animals.json");
		
		for(var a : pets1)
		{
			System.out.println(a.toString());
		}

	}

}
