package calin.stefaniadenisa.g1093.factory;

public class CruiseVacation extends AbstractVacation {

	public CruiseVacation(String country) {
		super(country, 2000);
	}

	@Override
	public void travel() {
		System.out.println("There is nothing more enticing, disenchanting, and enslaving than the life at sea. Have fun on your cruise!");
	}
	

}
