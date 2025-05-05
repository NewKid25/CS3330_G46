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
	/**
	 * gets id of pet
	 */
	@Override
	public int getId() {
		return id;
	}
	/**
	 * sets id of pet
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * gets name of pet
	 */
	@Override
	public String getName() {
		return name;
	}
	/**
	 * sets name of pet
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets type of pet
	 */
	public String getType() {
		return type;
	}
	/**
	 * sets type of pet
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * gets species of pet
	 */
	@Override
	public String getSpecies() {
		return species;
	}
	/**
	 * sets species of pet
	 */
	@Override
	public void setSpecies(String species) {
		this.species = species;
	}
	/**
	 * gets age of pet
	 */
	@Override
	public int getAge() {
		return age;
	}
	/**
	 * sets age of pet
	 */
	@Override
	public void setAge(int age) {
		this.age = age;
	}

}
