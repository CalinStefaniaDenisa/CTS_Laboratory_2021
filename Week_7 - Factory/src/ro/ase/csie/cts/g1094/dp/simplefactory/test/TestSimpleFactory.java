package ro.ase.csie.cts.g1094.dp.simplefactory.test;

import ro.ase.csie.cts.g1094.dp.simplefactory.Bazooka;
import ro.ase.csie.cts.g1094.dp.simplefactory.MachineGun;
import ro.ase.csie.cts.g1094.dp.simplefactory.Pistol;
import ro.ase.csie.cts.g1094.dp.simplefactory.Soldier;
import ro.ase.csie.cts.g1094.dp.simplefactory.WeaponType;
import ro.ase.csie.cts.g1094.dp.simplefactory.WeaponsFactory;

public class TestSimpleFactory {

	public static void main(String[] args) {

//		Soldier soldier = new Soldier("Bucky Barnes", new Pistol("Pistol", 100));
//		soldier.setWeapon(new MachineGun(500, 1000));
//		soldier.setWeapon(new Bazooka());
		
		Soldier soldier2 = new Soldier("Winter Soldier", WeaponsFactory.getWeapon(WeaponType.PISTOL, "Pistol"));
		soldier2.setWeapon(WeaponsFactory.getWeapon(WeaponType.MACHINE_GUN, "MG"));
		soldier2.setWeapon(WeaponsFactory.getWeapon(WeaponType.BAZOOKA, "Boom"));
	}

}
