package models;

public abstract class Pet {

    private boolean isAdopted;
   
	public abstract int getId();


	public abstract void setId(int id);


	public abstract String getName();

	public abstract void setName(String name);


	public abstract String getType();


	public abstract void setType(String type);


	public abstract String getSpecies();


	public abstract void setSpecies(String species);


	public abstract int getAge();


	public abstract void setAge(int age);


	public boolean isAdopted() {
		return isAdopted;
	}


	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}

}
