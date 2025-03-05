package middleearth.cms;

import middleearth.cms.MiddleEarthCouncil;
import middleearth.cms.characters.MiddleEarthCharacter;


public class MiddleEarthApp {
	public static void main(String[] args) {
		MiddleEarthCouncil council = new MiddleEarthCouncil();
		MiddleEarthCharacter character = new MiddleEarthCharacter("Gandalf", 100, 5);
		council.getmanagerinstance().addCharacter(character);
		MiddleEarthCharacter character2 = new MiddleEarthCharacter("Sauron", 100, 5);
		council.getmanagerinstance().addCharacter(character);
		council.getmanagerinstance().displayAllCharacters();
		council.getmanagerinstance().updateCharacter(character, "Gandalf", 90, 5);
		council.getmanagerinstance().getCharacter("Gandalf").attack("Sauron");
		council.getmanagerinstance().deleteCharacter(character);
		council.getmanagerinstance().deleteCharacter(character2);
		
	}
}
