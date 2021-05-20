package cts.calin.stefaniadenisa.g1094.pattern.factory;

public class OnlineBookingConcerts extends OnlineBooking {

	public OnlineBookingConcerts(String eventName, int price) {
		super(eventName, price);
	}

	@Override
	public String getType() {
		return "Concert";
	}
	
    public void displayDescription() {
        System.out.println(
                String.format("It's a %s type ticket for %s with a price of %d", this.getType(), eventName, price));
    }

}
