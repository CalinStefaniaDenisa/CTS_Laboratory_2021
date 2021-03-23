package ro.ase.csie.cts.g1094.singleton.staticReference;

public class DbConnection {

	String connectionString;
	String schema;
	
	// eager instantiation
	// static attribute! global reference to the unique object
	public final static DbConnection connection = new DbConnection();

	// static class initializer
	static {
		// called only once before the class is loaded by the JVM
		System.out.println("DbConnection is loaded.");
		connection.connectionString = "10.0.0.1:1443";
		connection.schema = "tempData";
	}
	
	// constructor initializer
	{
		// called everytime before any constructor call
		System.out.println("Building object...");
	}
	// NO public constructor for Singleton
	// default constructor
	// define it
	private DbConnection() {
		System.out.println("Creating an connection object...");
		System.out.println("Loading configuration...");
		this.connectionString = "127.0.0.1:1443";
		this.schema = "cts";
	}

	// not needed, replaced by the static class initializer
	// constructor with parameters
//	private DbConnection(String connectionString, String schema) {
//		this.connectionString = connectionString;
//		this.schema = schema;
//	}
	
	// no need for getConnection because the attribute is public final static
}
