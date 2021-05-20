package cts.calin.stefaniadenisa.g1094.pattern.flyweight;

public class Image implements DisplayedImage {
	
	private final String timeOfYear;
	private final int idTrip;
	
	

	public Image(String timeOfYear, int id) {
		super();
		this.timeOfYear = timeOfYear;
		this.idTrip = id;
	}



	@Override
	public void displayImage(GalleryImage image) {
		System.out.println("trip " + "happens in " + this.timeOfYear);
	}

}
