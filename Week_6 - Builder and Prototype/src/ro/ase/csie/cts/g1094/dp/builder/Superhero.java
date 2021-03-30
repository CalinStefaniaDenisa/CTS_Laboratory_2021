package ro.ase.csie.cts.g1094.dp.builder;

public class Superhero {

	String name;
	int lifePoints;
	boolean isVillain;
	boolean isWounded;

	WeaponInterface leftWeapon;
	WeaponInterface rightWeapon;
	
	String superPower;
	String superSuperPower;
	
	private Superhero() {

	}
	
	private Superhero(String name, int lifePoints, boolean isVillain, boolean isWounded, WeaponInterface leftWeapon,
			WeaponInterface rightWeapon, String superPower, String superSuperPower) {
		super();
		this.name = name;
		this.lifePoints = lifePoints;
		this.isVillain = isVillain;
		this.isWounded = isWounded;
		this.leftWeapon = leftWeapon;
		this.rightWeapon = rightWeapon;
		this.superPower = superPower;
		this.superSuperPower = superSuperPower;
	}
	
	public void takesAHit(int points) {
		this.lifePoints -= points;
		this.isWounded = true;
	}
	
	public void heal(int points) {
		this.lifePoints += points;
		if(this.lifePoints > 100) {
			this.lifePoints = 100;
			this.isWounded = false;
		}
	}
	
	public static class SuperheroBuilder {
		private Superhero superhero = null;
		
		// eager instantiation
		public SuperheroBuilder(String name, int lifePoints) {
			superhero = new Superhero();
			superhero.name = name;
			superhero.lifePoints = lifePoints;
		}
		
		public SuperheroBuilder isVillain() {
			superhero.isVillain = true;
			return this;
		}
		
		public SuperheroBuilder isWounded() {
			superhero.isWounded = true;
			return this;
		}
		
		public SuperheroBuilder addLeftWeapon(WeaponInterface weapon) {
			superhero.leftWeapon = weapon;
			return this;
		}
		
		public SuperheroBuilder addRightWeapon(WeaponInterface weapon) {
			superhero.leftWeapon = weapon;
			return this;
		}
		
		public SuperheroBuilder addSuperPower(String superPower) {
			superhero.superPower = superPower;
			return this;
		}

		public SuperheroBuilder addSuperSuperPower(String superSuperPower) {
			superhero.superSuperPower = superSuperPower;
			return this;
		}
		
		// Don't forget to provide it!
		public Superhero build() {
			return this.superhero;
		}
	}
	
	
	
}
