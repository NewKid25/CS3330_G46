package middleearth.cms.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	public abstract boolean attack(MiddleEarthCharacter target);
	
	public void displayInfo()
	{
		System.out.println(name+"has "+health +" health and "+power+" power");
	}
}
