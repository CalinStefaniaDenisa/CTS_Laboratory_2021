package ro.ase.csie.cts.g1094.dp.test;

import ro.ase.csie.cts.g1094.dp.builder.Pistol;
import ro.ase.csie.cts.g1094.dp.builder.Superhero;
import ro.ase.csie.cts.g1094.dp.builder.Superhero.SuperheroBuilder;

public class TestBuilder {

	public static void main(String[] args) {

		// create the object if default constructor is not private - BAD
//		Superhero superhero = new Superhero();
		// init the object
		// TO DO: don't forget to init all attributes!
//		superhero.name = "Superman";
//		superhero.lifePoints = 100;
		
		// Better solution if constructor with all arguments is not private - but not clean - BAD
//		Superhero superhero = new Superhero(
//				"Superman", 
//				100, 
//				false, 
//				false, 
//				null, 
//				new Pistol(), 
//				"Laser eyes", 
//				null);
		
		// Correct call of the builder
		Superhero superman = new Superhero.SuperheroBuilder("Superman", 100)
				.addSuperPower("Fly")
				.addLeftWeapon(new Pistol())
				.build();
		
		Superhero joker = new Superhero.SuperheroBuilder("Joker", 200)
				.isVillain()
				.addLeftWeapon(new Pistol())
				.addRightWeapon(new Pistol())
				.build();
	}

}
