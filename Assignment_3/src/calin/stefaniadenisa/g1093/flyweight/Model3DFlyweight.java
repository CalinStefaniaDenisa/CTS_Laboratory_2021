package calin.stefaniadenisa.g1093.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Model3DFlyweight implements Model3DFlyweightInterface {
	
	// shared data
	String modelName = "MainModel";
	List<Integer> points = new ArrayList<>();

	@Override
	public void loadModel(String filename) {
		System.out.println("Loading model...");
	}

	@Override
	public void display(NPCCoordinates coordinates) {
		System.out.println(String.format("Printing %s at coordinates (%d,%d,%d)",
				this.modelName, coordinates.x, coordinates.y, coordinates.z));
		
	}
}
