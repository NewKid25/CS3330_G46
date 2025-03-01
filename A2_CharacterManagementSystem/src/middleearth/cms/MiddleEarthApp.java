package middleearth.cms;

import middleearth.cms.characters.Dwarf;
import middleearth.cms.characters.Elf;

public class MiddleEarthApp {

	public static void main(String[] args) {
		
		var c1 = new Dwarf("bob", 10, 1);
		c1.displayInfo();
		var c2 = new Elf("phil", 9, 2);
		c2.displayInfo();
		
		c1.attack(c2);
		c1.displayInfo();
		c2.displayInfo();
	}

}
