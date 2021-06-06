package calin.stefaniadenisa.g1093.factory;

public class VacationFactory {
	
	public static AbstractVacation getVacation(VacationType type, String country) {
		AbstractVacation vacation = null;
		switch (type) {
		case BEACH_VACATION:
			vacation = new BeachVacation(country, 400);
			break;
		case CRUISE:
			vacation = new CruiseVacation(country);
			break;
		case CAMPING_VACATION:
			vacation = new CampingVacation(60);
			break;
		default:
			throw new UnsupportedOperationException();
		}
		
		return vacation;
	}

}
