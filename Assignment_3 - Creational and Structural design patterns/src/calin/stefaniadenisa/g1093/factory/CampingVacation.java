package calin.stefaniadenisa.g1093.factory;

public class CampingVacation extends AbstractVacation {

	public CampingVacation(int distance) {
		super("Country of residence", distance);
	}

	@Override
	public void travel() {
		System.out.println("Life is better by the camp fire. Enjoy your camping trip!");
	}

}
