package ro.ase.csie.cts.g1094.singleton.enumeration;

public enum DbConnection {

	// an enumeration with a single symbol is a singleton
	DEV_DB;

	String connectionString;
	String schema;
	
	private DbConnection() {
		System.out.println("Loading settings from the configuration file...");
	}
}
