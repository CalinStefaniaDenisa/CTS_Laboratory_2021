package ro.ase.csie.cts.g1094.dp.factory.test;

import ro.ase.csie.cts.g1094.dp.factory.AbstractFactory;
import ro.ase.csie.cts.g1094.dp.factory.RealWeaponsFactory;
import ro.ase.csie.cts.g1094.dp.factory.WaterPistol;
import ro.ase.csie.cts.g1094.dp.factory.WaterWeaponsFactory;
import ro.ase.csie.cts.g1094.dp.simplefactory.Soldier;
import ro.ase.csie.cts.g1094.dp.simplefactory.WeaponType;
import ro.ase.csie.cts.g1094.dp.simplefactory.WeaponsFactory;

public class TestFactory {

	public static void main(String[] args) {

		boolean kidsMode = true;
		Soldier soldier = null;
		
		if(kidsMode) {
			soldier = new Soldier("Bucky Barnes", new WaterPistol());
		} else {
			soldier = new Soldier("Buky Barnes", WeaponsFactory.getWeapon(WeaponType.PISTOL, ""));
		}
		
		// with factory method
		
		AbstractFactory weaponFactory = 
				(kidsMode == true) ? new WaterWeaponsFactory() : new RealWeaponsFactory();
		soldier = new Soldier("Bucky Barnes", weaponFactory.getWeapon(WeaponType.PISTOL, soldier.setWeapon(weaponFactory.getWeapon(WeaponType.BAZOOKA, ""));
	}

}
