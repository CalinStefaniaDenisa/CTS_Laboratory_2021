package calin.stefaniadenisa.g1093.adapter;

public abstract class ACMEVacation {

	public String destination;
	float stars;
	
	public ACMEVacation(String destination, float stars) {
		super();
		this.destination = destination;
		this.stars = stars;
	}

	public abstract String getDestination(String destination);
	public abstract float rankDestination(float starsLevel);
	public abstract void includedActivity();
	public abstract boolean isExotic();
	public abstract void exploreDestination();
}
