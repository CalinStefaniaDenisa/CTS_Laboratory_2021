package cts.calin.stefaniadenisa.g1094.pattern.factory;

public class OnlineBookingFactory {
	
	public static OnlineBooking createOnlineBooking(BookingType type, String eventName, int price) {
		
		OnlineBooking booking = null;
		switch( type ) {
		case CONCERTS:
			booking = new OnlineBookingConcerts(eventName, price);
			break;
		case EVENTS:
			booking = new OnlineBookingEvents(eventName);
			break;
		case MUSEUMS:
			booking = new OnlineBookingMuseums();
			break;
		default:
			throw new UnsupportedOperationException("Booking type not covered.");
		}
		
		return booking;
	}
	

}
