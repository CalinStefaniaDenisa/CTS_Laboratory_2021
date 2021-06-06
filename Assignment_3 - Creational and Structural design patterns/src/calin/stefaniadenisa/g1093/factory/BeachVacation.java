package calin.stefaniadenisa.g1093.factory;

public class BeachVacation extends AbstractVacation {

	public BeachVacation(String country, int distance) {
		super(country, distance);
	}

	@Override
	public void travel() {
		System.out.println("Yey! You will spend your vacation on the beach!");
	}
	

}
