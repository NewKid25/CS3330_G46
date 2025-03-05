package middleearth.cms.characters;

import java.util.Arrays;
import java.util.List;

public class Orc extends MiddleEarthCharacter{
	private final String race = "Orc";
	//List is used here to give us access to contains later, makes the code more readable
	private final List<String> vulnerableEnemies = Arrays.asList("Human");
	private final List<String> immuneEnemies = Arrays.asList("Elf", "Orc");
	
	public Orc(String name, double health, double power)
	{
		this.setName(name);
		this.setHealth(health);
		this.setPower(power);
	}
	
	public String getRace()
	{
		return race;
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target)
	{
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
			damage = 0;
		}

		target.setHealth(targetHealth-damage);
		return true;
	}
}
