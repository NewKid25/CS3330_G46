package middleearth.cms;

import middleearth.cms.characters.MiddleEarthCharacter;

public class CharacterManager {
	private int size =5;
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[size];
	private int nextOpenPosition =0; //CAN WE HAVE OUR OWN FIELDS/METHODS?
	
	/**
	 * Doubles the size of the character array
	 */
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
	/**
	 * Gets the index of a character in the characters array
	 * @param character Character to get
	 * @return index where the character's name was found, -1 if it was unable to find it
	 */
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
	
	/**
	 * Adds a character to this CharacterManager
	 * @param c Character to be added
	 * @return boolean representing whether this operation was successful or not
	 */
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
	
	/**
	 * Gets a Character this CharacterManager has
	 * @param name Name of the character to get
	 * @return The character that retrieved, or null if the operation failed
	 */
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
	
	/**
	 * Sets values of a character that this manager has to the given params
	 * @param character Character to set the values of
	 * @param name
	 * @param health
	 * @param power
	 * @return boolean representing whether this operation was successful or not
	 */
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
	 /**
	  * Removes a character that this manager has, freeing up the space
	  * @param character Character to remove
	  * @return boolean representing whether this operation was successful or not
	  */
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
	
	/**
	 * Prints how many characters are in this manager and their information
	 */
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
