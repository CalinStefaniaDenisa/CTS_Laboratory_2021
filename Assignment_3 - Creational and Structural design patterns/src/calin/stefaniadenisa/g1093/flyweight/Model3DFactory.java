package calin.stefaniadenisa.g1093.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Model3DFactory {
	static Map<String, Model3DFlyweightInterface> models = new HashMap<>();
	
	static {
		models.put(ModelType.BEACH.toString(), new Model3DFlyweight());
		models.put(ModelType.MOUNTAIN.toString(), new Model3DFlyweight());
	}
	
	public static Model3DFlyweightInterface getModel(ModelType type) {
		return models.get(type.toString());
	}

}
