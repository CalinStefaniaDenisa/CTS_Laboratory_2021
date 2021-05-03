package calin.stefaniadenisa.g1093.prototype;

import java.util.ArrayList;
import java.util.Random;

public class Destination3DModel implements Cloneable {
	boolean isMulticoloured;
	int height;
	
	// mandatory
	ArrayList<Integer> graphicPoints = new ArrayList<>();;
	
	public Destination3DModel(boolean isMulticoloured, int height) {
		this.isMulticoloured = isMulticoloured;
		this.height = height;
		
		System.out.println("Loading the 3D model...");
		try {
			Thread.sleep(2000);
			Random random = new Random(1000);
			for(int i = 0; i < 20; i++) {
				this.graphicPoints.add(random.nextInt(100));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Model loaded.");
	}

	private Destination3DModel() {
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Destination3DModel copy = new Destination3DModel();
		copy.isMulticoloured = this.isMulticoloured;
		copy.height = this.height;
		copy.graphicPoints = (ArrayList<Integer>) this.graphicPoints.clone();

		return copy;
	}
	
	

}
