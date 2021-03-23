package ro.ase.csie.cts.g1094.singleton;

public class TestSingleton {

	public static void main(String[] args) {

		// There is no public constructor !!!
//		DbConnection con1 = new DbConnection();
//		DbConnection con2 = new DbConnection();
//		DbConnection con = new DbConnection("127.0.0.1:3306", "cts");		
//		DbConnection con = new DbConnection("127.0.0.1:3306", "cts");

		
		// Singleton call
		DbConnection con1 = DbConnection.getConnection();
		DbConnection con2 = DbConnection.getConnection();

		
		// Incorrect -  no data at runtime
		// Misleading
		/* DbConnection con1 = DbConnection.getConnection("127.0.0.1:3306", "cts");
		 *
		 * DbConnection con2 = DbConnection.getConnection("127.0.0.1:3306", "cts");		
		 * DbConnection con3 = DbConnection.getConnection("127.0.0.1:3306", "productionDB");
		 */
		if(con1 == con2) {
			System.out.println("They are pointing to the same database.");
		}
	}

}
