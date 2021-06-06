package calin.stefaniadenisa.g1093.factory;

public abstract class AbstractVacation {
	String country;
	int distance;

	public AbstractVacation(String country, int distance) {
		super();
		this.country = country;
		this.distance = distance;
	}
	
	public abstract void travel();

}
