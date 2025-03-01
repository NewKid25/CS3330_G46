package middleearth.cms;

import middleearth.cms.characters.Dwarf;

public class Main {

	public static void main(String[] args) {
		
		var d1 = new Dwarf("bob", 10, 1);
		d1.displayInfo();
		var d2 = new Dwarf("phil", 9, 2);
		d2.displayInfo();
		
		d1.attack(d2);
		d1.displayInfo();
		d2.displayInfo();
	}

}
