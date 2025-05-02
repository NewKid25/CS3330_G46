package models;

public class NormalAnimal extends Pet{


	private int id;
    private String name;
    private String type;
    private String species;
    private int age;
    
	public NormalAnimal(int id, String name, String type, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
	}
    
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getSpecies() {
		return species;
	}
	
	@Override
	public void setSpecies(String species) {
		this.species = species;
	}
	
	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "NormalAnimal [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ "]";
	}
}
