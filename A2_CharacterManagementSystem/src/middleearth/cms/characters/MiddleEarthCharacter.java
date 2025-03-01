package middleearth.cms.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	public abstract boolean attack(MiddleEarthCharacter target);
	public abstract String getRace();
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getHealth() {
		return health;
	}



	public void setHealth(double health) {
		this.health = health;
	}



	public double getPower() {
		return power;
	}



	public void setPower(double power) {
		this.power = power;
	}



	public void displayInfo()
	{
		System.out.println(name+"has "+health +" health and "+power+" power");
	}
}
