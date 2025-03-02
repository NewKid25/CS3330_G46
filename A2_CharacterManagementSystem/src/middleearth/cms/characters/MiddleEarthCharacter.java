package middleearth.cms.characters;

public abstract class MiddleEarthCharacter {
	private String name;
	private double health;
	private double power;
	
	public abstract boolean attack(MiddleEarthCharacter target);
	public abstract String getRace();
	
	/**
	 * Gets the name of the character
	 * @return name of the character
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the name of the character
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the health of the character
	 * @return health of the character
	 */
	public double getHealth() {
		return health;
	}


	/**
	 * Sets the health of the character
	 * @param health
	 */
	public void setHealth(double health) {
		this.health = health;
	}


	/**
	 * Gets the power of the character
	 * @return power of the character
	 */
	public double getPower() {
		return power;
	}


	/**
	 * Sets the power of the character
	 * @param power
	 */
	public void setPower(double power) {
		this.power = power;
	}


	/**
	 * Prints name, health, and power of a character on one line
	 */
	public void displayInfo()
	{
		System.out.println(name+" has "+health +" health and "+power+" power");
	}
}
