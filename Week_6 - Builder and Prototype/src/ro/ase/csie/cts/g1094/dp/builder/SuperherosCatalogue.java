package ro.ase.csie.cts.g1094.dp.builder;

public class SuperherosCatalogue {
	Superhero.SuperheroBuilder builder;

	public SuperherosCatalogue(Superhero.SuperheroBuilder builder) {
		this.builder = builder;
	}
	
	public Superhero buildJoker() {
		return builder.isVillain()
				.addLeftWeapon(new Pistol())
				.addRightWeapon(new Pistol())
				.build();
	}
	
	public Superhero buildSuperman() {
		return builder.addSuperPower("Fly")
				.addLeftWeapon(new Pistol())
				.build();
	}
}
