package calin.stefaniadenisa.g1093.singleton;

public enum DbConnection {
	DEV_DB;
	
	String connString;
	String schema;
	
	private DbConnection() {
		System.out.println("Loading settings from the conf file");
	}
}
