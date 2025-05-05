package models;

public class ExoticAnimal extends Pet{

	private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;
    
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
	}
	/**
	 * gets id of pet
	 */
	@Override
	public int getId() {
		//ignore the part of the string that says "exo" just get numeric part and parse as int
		return Integer.parseInt((uniqueId.substring(3)))+100; //make sure every exotic animal has unique by adding (works if we have few of them)
	}
	/**
	 * sets id of pet
	 */
	@Override
	public void setId(int id) {
		this.uniqueId = "exo"+String.valueOf(id);
	}
	/**
	 * gets name of pet
	 */
	@Override
	public String getName() {
		return animalName;
	}
	/**
	 * sets name of pet
	 */
	@Override
	public void setName(String name) {
		this.animalName = name;
	}
	/**
	 * sets type of pet
	 */
	public String getType() {
		return category;
	}
	/**
	 * gets type of pet
	 */
	@Override
	public void setType(String type) {
		this.category = type;
	}
	/**
	 * gets species of pet
	 */
	@Override
	public String getSpecies() {
		return subSpecies;
	}
	/**
	 * sets species of pet
	 */
	@Override
	public void setSpecies(String species) {
		this.subSpecies = species;
	}
	/**
	 * gets age of pet
	 */
	@Override
	public int getAge() {
		return yearsOld;
	}
	/**
	 * sets age of pet
	 */
	@Override
	public void setAge(int age) {
		this.yearsOld = age;
	}	
}
