package middleearth.cms;

/**
 * MiddleEarthCouncil getinstance:
 * CharacterManager getmanagerinstance:
 */
public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	
	public static MiddleEarthCouncil getinstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
		}

	private CharacterManager managerinstance;
	
	public CharacterManager getmanagerinstance() {
		if(managerinstance == null) {
			managerinstance = new CharacterManager();
		}
		return managerinstance;
		}
}