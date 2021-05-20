package cts.calin.stefaniadenisa.g1094.pattern.factory;

public class OnlineBookingEvents extends OnlineBooking {

	public OnlineBookingEvents(String eventName) {
		super(eventName, 500);
	}

	@Override
	public String getType() {
		return "Events";
	}
	
    public void displayDescription() {
        System.out.println(
                String.format("It's a %s type ticket for %s with a price of %d", this.getType(), eventName, price));
    }

}
