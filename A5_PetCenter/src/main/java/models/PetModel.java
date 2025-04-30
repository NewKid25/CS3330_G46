package models;

public class PetModel {
    private int id;
    private String name;
    private String type;
    private String species;
    private int age;
    private boolean isAdopted;
    
    
	public PetModel(int id, String name, String type, String species, int age, boolean isAdopted) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.isAdopted = isAdopted;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isAdopted() {
		return isAdopted;
	}


	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}
}
