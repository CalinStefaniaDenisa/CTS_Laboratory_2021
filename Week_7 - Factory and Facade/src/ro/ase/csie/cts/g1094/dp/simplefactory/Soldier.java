package ro.ase.csie.cts.g1094.dp.simplefactory;

public class Soldier {
	
	String name;
	AbstractWeapon weapon;
	public Soldier(String name, AbstractWeapon weapon) {
		super();
		this.name = name;
		this.weapon = weapon;
	}

	public void setWeapon(AbstractWeapon weapon) {
		this.weapon = weapon;
	}
	
	

}
