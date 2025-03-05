package middleearth.cms;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance1;
	String character;
	
	MiddleEarthCouncil (String character){
		this.character = character;
		}
	
	public static MiddleEarthCouncil getinstance(String character) {
		if(instance1 == null) {
			instance1 = new MiddleEarthCouncil(character);
		}
			return instance1;
}
	CharacterManager getCharacterManager(){
		private static MiddleEarthCouncil instance;
		String manager;
		
		private MiddleEarthCouncil instance2(String manager){
			this.manager = manager;
			}
		public static MiddleEarthCouncil getinstance1(String manager) {
			if(instance1 == null) {
				instance1 = new MiddleEarthCouncil(manager);
				}
			return instance1;
	}
		
}