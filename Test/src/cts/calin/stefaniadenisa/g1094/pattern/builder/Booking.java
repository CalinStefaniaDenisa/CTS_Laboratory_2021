package cts.calin.stefaniadenisa.g1094.pattern.builder;

public class Booking {
	String eventName;
    int price;
	IncludedBreakfastInterface includedBreakfast;
	int nrOfPersons;
	BedType bedType;
	boolean withSeasideView;

	private Booking() {
		
	}

	private Booking(String eventName, int price, IncludedBreakfastInterface includedBreakfast, int nrOfPersons, BedType bedType,
			boolean withSeasideView) {
		super();
		this.eventName = eventName;
		this.price = price;
		this.includedBreakfast = includedBreakfast;
		this.nrOfPersons = nrOfPersons;
		this.bedType = bedType;
		this.withSeasideView = withSeasideView;
	}


	public String getEventName() {
		return eventName;
	}

	public int getPrice() {
		return price;
	}


	public IncludedBreakfastInterface getIncludedBreakfast() {
		return includedBreakfast;
	}

	public int getNrOfPersons() {
		return nrOfPersons;
	}

	public BedType getBedType() {
		return bedType;
	}

	public boolean isWithSeasideView() {
		return withSeasideView;
	}
	
	public static class BookingBuilder {
		
		private Booking booking = null;
		
		public BookingBuilder(String eventName, int price) {
			this.booking = new Booking();
			this.booking.eventName = eventName;
			this.booking.price = price;
		}
		
		public BookingBuilder addIncludedBreakfast() {
			this.booking.includedBreakfast = new IncludedBreakfast();
			this.booking.includedBreakfast.addIncludedBreakfast();
			return this;
		}
		
		public BookingBuilder setNoOfPersons(int noPersons) {
			this.booking.nrOfPersons = noPersons;
			return this;
		}
		
		public BookingBuilder setBedType (BedType bedType) {
			this.booking.bedType = bedType;
			return this;
		}
		
		public BookingBuilder addWithSeasideView () {
			this.booking.withSeasideView = true;
			return this;
		}
		
		public Booking build() {
			return this.booking;
		}		
		
	}
	
	
	

}
