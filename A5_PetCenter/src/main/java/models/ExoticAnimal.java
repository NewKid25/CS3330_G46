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
    
	@Override
	public int getId() {
		//ignore the part of the string that says "exo" just get numeric part and parse as int
		return Integer.parseInt((uniqueId.substring(3)));
	}
	
	@Override
	public void setId(int id) {
		this.uniqueId = "exo"+String.valueOf(id);
	}
	
	@Override
	public String getName() {
		return animalName;
	}
	
	@Override
	public void setName(String name) {
		this.animalName = name;
	}
	
	public String getType() {
		return category;
	}
	
	@Override
	public void setType(String type) {
		this.category = type;
	}
	
	@Override
	public String getSpecies() {
		return subSpecies;
	}
	
	@Override
	public void setSpecies(String species) {
		this.subSpecies = species;
	}
	
	@Override
	public int getAge() {
		return yearsOld;
	}
	
	@Override
	public void setAge(int age) {
		this.yearsOld = age;
	}
	
}
