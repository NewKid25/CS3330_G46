package models;

public abstract class Pet implements Comparable<Pet>{
	/**
	 * gets if pet is adopted or not
	 */
    private boolean isAdopted;
    /**
	 * gets id of pet
	 */
	public abstract int getId();
	
	/**
	 * sets id of pet
	 */
	public abstract void setId(int id);

	/**
	 * gets name of pet
	 */
	public abstract String getName();

	/**
	 * sets name of pet
	 */
	public abstract void setName(String name);

	/**
	 * gets type of pet
	 */
	public abstract String getType();

	/**
	 * sets type of pet
	 */
	public abstract void setType(String type);

	/**
	 * gets species of pet
	 */
	public abstract String getSpecies();

	/**
	 * sets species of pet
	 */
	public abstract void setSpecies(String species);

	/**
	 * gets age of pet
	 */
	public abstract int getAge();

	/**
	 * sets age of pet
	 */
	public abstract void setAge(int age);

	/**
	 * gets adoption status of pet
	 */
	public boolean isAdopted() {
		return isAdopted;
	}

	/**
	 * sets adoption status of pet
	 */
	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}
	
	/**
	 * compare to method for pet
	 */
	@Override
	public int compareTo(Pet p) {
		// can use comparable for name, use comparators for sorting on other attributes
		return this.getName().compareTo(p.getName());
	}
	/**
	 * to String method for a pet
	 */
	@Override
	public String toString()
	{
		var petString = getName() + ", " + getType();
		if(isAdopted)
		{
			petString+=", Adopted";
		}
		return petString;
	}
}
