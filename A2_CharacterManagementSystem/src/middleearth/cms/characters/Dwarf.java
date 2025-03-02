package middleearth.cms.characters;

import java.util.Arrays;
import java.util.List;

public class Dwarf extends MiddleEarthCharacter{

	private final String race = "Dwarf";
	//List is used here to give us access to contains later, makes the code more readable
	private final List<String> vulnerableEnemies = Arrays.asList("Elf");
	private final List<String> immuneEnemies = Arrays.asList("Wizard", "Dwarf");
	
	/**
	* Makes a new Dwarf
	* @param name Name of the creature
	* @param health health of the creature
	* @param power amount of damage creature will do in a normal attack
	*/
	public Dwarf(String name, double health, double power)
	{
		this.setName(name);
		this.setHealth(health);
		this.setPower(power);
	}
	
	/**
	* returns String representing race
	*/
	public String getRace()
	{
		return race;
	}
	
	
	/**
	* reduce health of target based on race and this character's power
	* @param target character that will have it's health reduced
	* @return boolean describing whether attack did damage or not
	*/
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if(target == null)
		{
			return false;			
		}
		
		double targetHealth = target.getHealth();
		double damage = this.getPower();
		var targetRace = target.getRace();
		if(vulnerableEnemies.contains(targetRace))
		{
			damage *= 1.5;
		}
		else if (immuneEnemies.contains(targetRace))
		{
			return false;
		}

		target.setHealth(targetHealth-damage);
		return true;
	}
}
