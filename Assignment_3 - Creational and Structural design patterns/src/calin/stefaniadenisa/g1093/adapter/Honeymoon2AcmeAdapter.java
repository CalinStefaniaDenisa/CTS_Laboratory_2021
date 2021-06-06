package calin.stefaniadenisa.g1093.adapter;

import calin.stefaniadenisa.g1093.adapter.honeymoon.HoneymoonActivities;

public class Honeymoon2AcmeAdapter extends ACMEVacation {
	
	HoneymoonActivities honeymoonActivity = null;
	
	public Honeymoon2AcmeAdapter(HoneymoonActivities honeymoonActivity) {
		super(honeymoonActivity.getCity(), honeymoonActivity.getRating());
		this.honeymoonActivity = honeymoonActivity;
	}

	@Override
	public String getDestination(String destination) {
		return this.honeymoonActivity.getCity();
	}

	@Override
	public float rankDestination(float starsLevel) {
		return this.honeymoonActivity.rateDestination(starsLevel);
	}

	@Override
	public void includedActivity() {
		this.honeymoonActivity.goToSpa();
		
	}

	@Override
	public boolean isExotic() {
		return this.honeymoonActivity.isTropical();
	}

	@Override
	public void exploreDestination() {
		this.honeymoonActivity.takeGondola();
		
	}

	
	
	

}
