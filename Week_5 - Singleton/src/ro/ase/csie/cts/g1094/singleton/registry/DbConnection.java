package ro.ase.csie.cts.g1094.singleton.registry;

import java.util.Hashtable;

public class DbConnection {

	String connectionString;
	String schema;
	//connectionString is different for 2 objects
	
	private static Hashtable<String, DbConnection> connections = new Hashtable<>();
	
	
	// NO public constructor for Singleton
	// default constructor
	// define it
	private DbConnection() {
		System.out.println("Creating an connection object...");
		System.out.println("Loading configuration...");
		this.connectionString = "127.0.0.1:1443";
		this.schema = "cts";
	}

	// constructor with parameters
	private DbConnection(String connectionString, String schema) {
		this.connectionString = connectionString;
		this.schema = schema;
	}
	
	public static DbConnection getDbConnection(String connectionString, String schema) {
		DbConnection connection = connections.get(connectionString);
		if(connection == null) {
			connection = new DbConnection(connectionString, schema);
			connections.put(connectionString, connection);
		}
		return connection;
	}
}
