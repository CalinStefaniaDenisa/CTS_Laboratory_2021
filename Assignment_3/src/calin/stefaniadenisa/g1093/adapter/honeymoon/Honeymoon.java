package calin.stefaniadenisa.g1093.adapter.honeymoon;

public class Honeymoon implements HoneymoonActivities {
	public final String city = "Venice";
	float rating;
	
	public Honeymoon(float rating) {
		super();
		this.rating = rating;
	}


	@Override
	public String getCity() {
		System.out.println("Your honeymoon will be in " + this.city);
		return this.city;
	}

	@Override
	public float rateDestination(float ratingLevel) {
		rating -= ratingLevel*0.1;
		System.out.println("The rating of the location after your rating is " + rating + " out of 5");
		return rating;
	}

	@Override
	public void goToSpa() {
		System.out.println("You have spa sessions included.");
		
	}

	@Override
	public boolean isTropical() {
		return false;
		
	}

	@Override
	public void takeGondola() {
		System.out.println("At the sunset, enjoy a gondola ride");
	}


	@Override
	public float getRating() {
		return this.rating;
	}

}
