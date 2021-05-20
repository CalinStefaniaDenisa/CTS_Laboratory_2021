package cts.calin.stefaniadenisa.g1094.pattern.builder;

public class BookingTest {

	public static void main(String[] args) {

		Booking booking1 = new Booking.BookingBuilder("Getaway", 1000)
				.addIncludedBreakfast()
				.addWithSeasideView()
				.setBedType(BedType.DOUBLE)
				.build();
		
		Booking booking2 = new Booking.BookingBuilder("Trip to Venice", 5000)
				.addWithSeasideView()
				.setBedType(BedType.SINGLE)
				.setNoOfPersons(3)
				.build();
		
		Booking booking3 = new Booking.BookingBuilder("Delegation", 300)
				.setNoOfPersons(1)
				.setBedType(BedType.SINGLE)
				.addIncludedBreakfast()
				.build();
	}

}
