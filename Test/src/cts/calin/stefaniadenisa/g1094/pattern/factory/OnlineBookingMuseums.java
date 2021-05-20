package cts.calin.stefaniadenisa.g1094.pattern.factory;

public class OnlineBookingMuseums extends OnlineBooking {
	
	public OnlineBookingMuseums() {
		super("Antipa Opening", 15);
	}

	@Override
	public String getType() {
		return "Museums";
	}
	
    public void displayDescription() {
        System.out.println(
                String.format("It's a %s type ticket for %s with a price of %d", this.getType(), eventName, price));
    }
	

}
