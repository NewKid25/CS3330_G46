package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.NormalAnimal;
import models.Pet;
import models.ExoticAnimal; 

public class PetJsonParser {
	Gson gson = new Gson();
	
	public List<NormalAnimal> ReadNormalAnimals(String filePath)
	{
        Type animalListType = new TypeToken<List<NormalAnimal>>(){}.getType();
        return ParsePetJson(filePath, animalListType);
	}
	
	public List<ExoticAnimal> ReadExoticAnimals(String filePath)
	{
        Type animalListType = new TypeToken<List<ExoticAnimal>>(){}.getType();
        return ParsePetJson(filePath, animalListType);
	}
	
	private <T extends Pet> List<T> ParsePetJson(String filePath, Type animalListType)
	{
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
	    {
	    	String json ="";
	    	String line;
            while (( line = reader.readLine()) != null)
            {
            	json += line;
            }
//            System.out.println(json);
	    	List<T> animals = gson.fromJson(json, animalListType);
	    	return animals;
        }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    	
	    	return null;
	    }
	}
}
