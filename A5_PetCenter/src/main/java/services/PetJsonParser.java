package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
	    	List<T> animals = gson.fromJson(json, animalListType);
	    	return animals;
        }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    	
	    	return null;
	    }
	}
	
	public void WritePetsToFile(List<Pet> petList, String filePathToDir)
	{
		var jsonString = gson.toJson(petList);
		System.out.println(jsonString);

        LocalDateTime currentTime = LocalDateTime.now();        
        String formattedDateTime = currentTime.format(DateTimeFormatter.ofPattern("yyyymmdd_hhmmss"));

		String filePath = filePathToDir + formattedDateTime +  "_pets.json";
		
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(jsonString);
        }
         catch (IOException e) {
            System.err.println("Error writing pets to file: " + e.getMessage());
        }
	}
}
