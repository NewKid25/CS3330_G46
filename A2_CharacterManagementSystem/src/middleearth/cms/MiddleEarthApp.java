package middleearth.cms;

import java.util.Scanner;

import middleearth.cms.MiddleEarthCouncil;
import middleearth.cms.characters.MiddleEarthCharacter;
import middleearth.cms.characters.Wizard;


public class MiddleEarthApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true){
		MiddleEarthCouncil council = new MiddleEarthCouncil();
		
		System.out.println("Name of character: ");
		String heroname = scanner.nextLine();
		MiddleEarthCharacter character = new Wizard(heroname, 100.0, 5.0);
		council.getmanagerinstance().addCharacter(character);
		
		System.out.println("Name of villian: ");
		String villianname = scanner.nextLine();
		MiddleEarthCharacter character2 = new Wizard(villianname, 100, 5);
		council.getmanagerinstance().addCharacter(character2);
		
		council.getmanagerinstance().displayAllCharacters();
		
		System.out.println("Would you like to update your character? (y/n): ");
		if(scanner.nextLine() == "y") {
			System.out.println("What would you like to change? (name, hp, power)");
			if(scanner.nextLine() == "name") {
				System.out.println("New hero name: ");
				String newname = scanner.nextLine();
				council.getmanagerinstance().updateCharacter(character, newname, character.getHealth(), character.getPower());
			}
			if(scanner.nextLine() == "hp") {
				System.out.println("New hero hp: ");
				String hp = scanner.nextLine();
				council.getmanagerinstance().updateCharacter(character, character.getName(), hp, character.getPower());
			}
			if(scanner.nextLine() == "power") {
				System.out.println("New hero power: ");
				String power = scanner.nextLine();
				council.getmanagerinstance().updateCharacter(character, character.getName(),character.getHealth(), power);
			}
			else {
				break;
			}
			
		}
		System.out.println("Who would you like to attack?: ");
		String villian = scanner.nextLine();
		if(council.getmanagerinstance().getCharacter(villian) != null) {
			council.getmanagerinstance().getCharacter(heroname).attack(council.getmanagerinstance().getCharacter(villian));
		}
		System.out.println("Who would you like to delete your characters?: ");
		if(scanner.nextLine() == "y") {
			council.getmanagerinstance().deleteCharacter(character);
			council.getmanagerinstance().deleteCharacter(character2);
		}
		System.out.println("Would you like to exit this program?: ");
		if(scanner.nextLine() == "n") {
			break;
		}
	}
}
}
