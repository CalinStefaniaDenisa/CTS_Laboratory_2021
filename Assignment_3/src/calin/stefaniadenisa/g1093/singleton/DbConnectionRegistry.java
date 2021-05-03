package calin.stefaniadenisa.g1093.singleton;

import java.util.Hashtable;

public class DbConnectionRegistry {
	String connString;
	String schema;
	
	private static Hashtable<String, DbConnectionRegistry> connections = new Hashtable<>();
	
	private DbConnectionRegistry() {
		System.out.println("Creating a connection object");
		System.out.println("Loading configuration.....");
		this.connString = "10.10.10.11:2020";
		this.schema = "bachelor";
	}

	private DbConnectionRegistry(String connString, String schema) {
		super();
		this.connString = connString;
		this.schema = schema;
	}
	
	public static DbConnectionRegistry getDbConnection(String connString, String schema) {
		DbConnectionRegistry connection = connections.get(connString);
		if(connection == null) {
			connection = new DbConnectionRegistry(connString, schema);
			connections.put(connString, connection);
		}
		return connection;
	}
}
