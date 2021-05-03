package calin.stefaniadenisa.g1093.builder;

public class TravelDestination {
	
	private String name;
	private int stars;
	
	private boolean isExotic;
	private boolean needsVaccineProof;
	
	private MeanOfTransportInterface transportation;

	private TravelDestination() {
		
	}

	private TravelDestination(
								String name, 
								int stars, 
								boolean isExotic, 
								boolean needsVaccineProof,
								MeanOfTransportInterface transportation) {
		super();
		this.name = name;
		this.stars = stars;
		this.isExotic = isExotic;
		this.needsVaccineProof = needsVaccineProof;
		this.transportation = transportation;
	}
	
	public static class TravelDestinationBuilder {
		TravelDestination travelDestination;
		
		public TravelDestinationBuilder(String name, int stars) {
			this.travelDestination = new TravelDestination();
			this.travelDestination.name = name;
			this.travelDestination.stars = stars;
		}
		
		public TravelDestinationBuilder isExotic() {
			this.travelDestination.isExotic = true;
			return this;
		}
		
		public TravelDestinationBuilder needsVaccineProof() {
			this.travelDestination.needsVaccineProof = true;
			return this;
		}
		
		public TravelDestinationBuilder setMeanOfTransport(MeanOfTransportInterface transportation) {
			this.travelDestination.transportation = transportation;
			transportation.transport();
			return this;
		}

		public TravelDestination build() {
			return this.travelDestination;
		}
	}
	
	
	
	

}
