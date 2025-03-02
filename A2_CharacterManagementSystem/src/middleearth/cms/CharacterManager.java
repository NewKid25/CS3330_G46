package middleearth.cms;

import middleearth.cms.characters.MiddleEarthCharacter;

public class CharacterManager {
	private int size =5;
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[size];
	private int nextOpenPosition =0; //CAN WE HAVE OUR OWN FIELDS/METHODS?
	
	
	private void extendCharactersArray()
	{
		size *= 2;
		var newArray = new MiddleEarthCharacter[size];
		
		for(int i =0; i<characters.length; i++)
		{
			newArray[i] = characters[i];
		}
		characters=newArray;
	}
	
	private int getCharacterIndex(MiddleEarthCharacter character)
	{
		if(character != null)
		{			
			for(int i=0; i<size;i++)
			{
				if(characters[i] == null)
				{
					break;
				}
				if(character.getName().equals(characters[i].getName()))
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) //WHAT IF MULTPLE OF SAME CHARACTER INSERTED
	{
		if(nextOpenPosition == size) //i.e. the array is full
		{
			extendCharactersArray();
		}
		characters[nextOpenPosition] = c; //SHOULD THIS BE A COPY?
		nextOpenPosition++;
		return true;
	}
	
	public MiddleEarthCharacter getCharacter(String name)
	{
		for(var character : characters)
		{
			if(character.getName().equals(name))
			{
				return character;
			}
		}
		return null;
	}
	
	public boolean updateCharacter (MiddleEarthCharacter character, String name, int health, int power)
	{
		if(character == null || name == null)//bad params
		{
			return false;
		}
		
		var characterToUpdate = getCharacter(character.getName());
		if(characterToUpdate != null) 
		{
			//check if anything is going to change
			if(!characterToUpdate.getName().equals(name) ||
					characterToUpdate.getHealth() != health ||
					characterToUpdate.getPower()!=power) 
			{
				characterToUpdate.setName(name);
				characterToUpdate.setHealth(health);
				characterToUpdate.setPower(power);
				return true;
			}		
		}
		return false;
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character)
	{
		var characterToDeleteIndex = getCharacterIndex(character);
		if(characterToDeleteIndex != -1)
		{
			characters[characterToDeleteIndex] = null;
			for(int i=characterToDeleteIndex; i<size-1;i++)
			{
				characters[i]=characters[i+1];
			}
			nextOpenPosition--;
			return true;
		}
		return false;

	}
	
	public void displayAllCharacters() 
	{
		System.out.println("There are " +nextOpenPosition+ " characters in the CharacterManager");
		for(var character : characters)
		{
			if(character == null)
			{
				return;
			}
			character.displayInfo();
		}
	}
}
