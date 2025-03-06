package middleearth.cms;

import middleearth.cms.MiddleEarthCouncil;
import middleearth.cms.characters.MiddleEarthCharacter;
import middleearth.cms.characters.Wizard;


public class MiddleEarthApp {
	public static void main(String[] args) {
		MiddleEarthCouncil council = new MiddleEarthCouncil();
		MiddleEarthCharacter character = new Wizard("Gandalf", 100.0, 5.0);
		council.getmanagerinstance().addCharacter(character);
		MiddleEarthCharacter character2 = new Wizard("Sauron", 100, 5);
		council.getmanagerinstance().addCharacter(character2);
		council.getmanagerinstance().displayAllCharacters();
		council.getmanagerinstance().updateCharacter(character, "Gandalf", 90, 5);
		council.getmanagerinstance().getCharacter("Gandalf").attack(character2);
		council.getmanagerinstance().deleteCharacter(character);
		council.getmanagerinstance().deleteCharacter(character2);
		
	}
}
