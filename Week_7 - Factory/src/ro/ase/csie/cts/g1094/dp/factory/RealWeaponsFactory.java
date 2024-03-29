package ro.ase.csie.cts.g1094.dp.factory;

import ro.ase.csie.cts.g1094.dp.simplefactory.AbstractWeapon;
import ro.ase.csie.cts.g1094.dp.simplefactory.Bazooka;
import ro.ase.csie.cts.g1094.dp.simplefactory.MachineGun;
import ro.ase.csie.cts.g1094.dp.simplefactory.Pistol;
import ro.ase.csie.cts.g1094.dp.simplefactory.WeaponType;

public class RealWeaponsFactory extends AbstractFactory {
	
	public AbstractWeapon getWeapon(WeaponType type, String description) {
		
		AbstractWeapon weapon = null;
		switch(type) {
		case PISTOL:
			weapon = new Pistol(description, 100);
			break;
		case MACHINE_GUN:
			weapon = new MachineGun(500, 1000);
			weapon.setDescription(description);
			break;
		case BAZOOKA:
			weapon = new Bazooka();
			weapon.setDescription(description);
			break;
		default:
			throw new UnsupportedOperationException("Type not covered");
		}
		
		return weapon;
	}

}
