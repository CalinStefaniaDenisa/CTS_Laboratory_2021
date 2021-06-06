package calin.stefaniadenisa.g1093.adapter;

public class Vacation extends ACMEVacation {

	public Vacation(String destination, float stars) {
		super(destination, stars);
	}

	@Override
	public String getDestination(String destination) {
		System.out.println("Your vacation will be in " + destination);
		return this.destination;
	}

	@Override
	public float rankDestination(float starsLevel) {
		stars -= starsLevel*0.1;
		System.out.println("The location now has " + stars + " stars out of 5");
		return stars;
	}

	@Override
	public void includedActivity() {
		System.out.println("You have extra activities included.");
		
	}

	@Override
	public boolean isExotic() {
		return false;
	}

	@Override
	public void exploreDestination() {
		System.out.println("Explore this amazing destination");
		
	}

}
