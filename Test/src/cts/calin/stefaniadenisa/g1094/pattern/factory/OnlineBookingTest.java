package cts.calin.stefaniadenisa.g1094.pattern.factory;

public class OnlineBookingTest {
	public static void main(String[] args) {
		
		OnlineBookingFactory factory = new OnlineBookingFactory();
		
		OnlineBooking booking1 = OnlineBookingFactory.createOnlineBooking(BookingType.CONCERTS, "Metallica Concert", 100);
		OnlineBooking booking2 = OnlineBookingFactory.createOnlineBooking(BookingType.EVENTS, "Grammy's", 0);
		OnlineBooking booking3 = OnlineBookingFactory.createOnlineBooking(BookingType.MUSEUMS, null, 0);
		
		booking1.displayDescription();
		booking2.displayDescription();
		booking3.displayDescription();

	}

}
