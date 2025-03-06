package middleearth.cms;

import java.util.Scanner;

import middleearth.cms.MiddleEarthCouncil;
import middleearth.cms.characters.Dwarf;
import middleearth.cms.characters.Elf;
import middleearth.cms.characters.Human;
import middleearth.cms.characters.MiddleEarthCharacter;
import middleearth.cms.characters.Orc;
import middleearth.cms.characters.Wizard;


public class MiddleEarthApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MiddleEarthCouncil council = new MiddleEarthCouncil();
		while(true){
		
		System.out.println("1. Add Character");
		System.out.println("2. View all Characters");
		System.out.println("3. Update Character");
		System.out.println("4. Delete Character");
		System.out.println("5. Execute All Character's Attacks");
		System.out.println("6. Exit");
		System.out.println("");
		System.out.println("What do you want to do?");
		var input = scanner.nextLine();
		
		if(input.equals("1")) {
			System.out.println("Name of character: ");
			String heroname = scanner.nextLine();
			System.out.println("Race of character: ");
			String herorace = scanner.nextLine();
			
			if(herorace.equals("Dwarf") || herorace.equals("dwarf")) {
				MiddleEarthCharacter character = new Dwarf(heroname, 100.0, 3.0);
				council.getmanagerinstance().addCharacter(character);
			}
			else if(herorace.equalsIgnoreCase("elf")) {
				MiddleEarthCharacter character = new Elf(heroname, 80.0, 2.0);
				council.getmanagerinstance().addCharacter(character);
			}
			else if(herorace.equalsIgnoreCase("human")) {
				MiddleEarthCharacter character = new Human(heroname, 60.0, 1.0);
				council.getmanagerinstance().addCharacter(character);
			}
			else if(herorace.equalsIgnoreCase("orc")) {
				MiddleEarthCharacter character = new Orc(heroname, 70.0, 4.0);
				council.getmanagerinstance().addCharacter(character);
			}
			else if(herorace.equalsIgnoreCase("wizard")) {
				MiddleEarthCharacter character = new Wizard(heroname, 5.0, 6.0);
				council.getmanagerinstance().addCharacter(character);
			}
		}
		else if(input.equals("2")) {
			council.getmanagerinstance().displayAllCharacters();
		}
		else if(input.equals("3")) {
			System.out.println("What character would you like to change? (name)");
			String charname = scanner.nextLine();
			MiddleEarthCharacter character = council.getmanagerinstance().getCharacter(charname);
			System.out.println("What would you like to change? (name, hp, power)");
			var updateInput = scanner.nextLine();
			if(updateInput.equalsIgnoreCase("name")) {
				System.out.println("New hero name: ");
				String newname = scanner.nextLine();
				council.getmanagerinstance().updateCharacter(council.getmanagerinstance().getCharacter(charname), newname, (int)character.getHealth(), (int)character.getPower());
			}
			if(updateInput.equalsIgnoreCase("hp")) {
				System.out.println("New hero hp: ");
				var hp = Integer.parseInt(scanner.nextLine());
				council.getmanagerinstance().updateCharacter(character, character.getName(), hp, (int)character.getPower());
			}
			if(updateInput.equalsIgnoreCase("power")) {
				System.out.println("New hero power: ");
				var power = Integer.parseInt(scanner.nextLine());
				council.getmanagerinstance().updateCharacter(character, character.getName(),(int)character.getHealth(), power);
			}		
		}
		else if(input.equals("4")) {
			System.out.println("What character would you like to delete? (name)");
			String charname = scanner.nextLine();
			MiddleEarthCharacter character = council.getmanagerinstance().getCharacter(charname);
			council.getmanagerinstance().deleteCharacter(character);
		}
		else if(input.equals("5")) {
			System.out.println("What hero would you like to attack with?: ");
			String heroname = scanner.nextLine();
			System.out.println("Who would you like to attack?: ");
			String villian = scanner.nextLine();
			if(council.getmanagerinstance().getCharacter(villian) != null) {
				council.getmanagerinstance().getCharacter(heroname).attack(council.getmanagerinstance().getCharacter(villian));
			}
		}
		else if(input.equals("6")) {
			break;
		}
	}
}
}
