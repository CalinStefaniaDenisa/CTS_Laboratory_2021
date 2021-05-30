package ro.ase.csie.cts.assignment3.prototype.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.assignment3.prototype.Server;

public class TestServer {
	
		Server server = null;
		static String ipAddress = "172.16.254.1";
		static int port = 2020;
		static int maxConnections = 3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPortCloneConformanceRight() {
		server = new Server(ipAddress, port, maxConnections);
		Server copy = (Server) server.clone();
		assertEquals("Test cu valori corecte", server.getPort(), copy.getPort());
	}

}
