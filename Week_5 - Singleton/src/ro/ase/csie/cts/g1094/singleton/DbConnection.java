package ro.ase.csie.cts.g1094.singleton;

public class DbConnection {

	String connectionString;
	String schema; // database name
	
	// NO public constructor for Singleton
	// static attribute! reference to the unique object
	private static DbConnection connection = null;

	// default constructor
	private DbConnection() {
		System.out.println("Creating an connection object...");
		System.out.println("Loading configuration...");
		this.connectionString = "127.0.0.1:1443";
		this.schema = "cts";
	}

	// constructor with parameters
	private DbConnection(String connectionString, String schema) {
		super();
		this.connectionString = connectionString;
		this.schema = schema;
	}
	
	// lazy instantiation of the unique object - don't create the object until someone needs them
	// global function
	public static DbConnection getConnection() {
		// executed only once
		if (DbConnection.connection == null) {
			connection = new DbConnection();
		}
		return DbConnection.connection;
	}
	
	// don't do this
	// not clean
	// misleading - others will think they have multiple connections
	public static DbConnection getConnection(String connectionString, String schema) {
		// executed only once
		if (DbConnection.connection == null) {
			connection = new DbConnection(connectionString, schema);
		}
		return DbConnection.connection;
	}
	
	 
}
