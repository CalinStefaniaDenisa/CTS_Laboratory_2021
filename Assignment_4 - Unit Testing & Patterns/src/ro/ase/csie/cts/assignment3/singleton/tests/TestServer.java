package ro.ase.csie.cts.assignment3.singleton.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.assignment3.exceptions.ExistentServerException;
import ro.ase.csie.cts.assignment3.singleton.Server;

public class TestServer {
	
	static Server server;
	static String ipAddress = "172.16.254.1";

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
		server = null;

	}

	@Test(expected = ExistentServerException.class)
	public void testSingletonErrorCondition() throws ExistentServerException {
		Server server1 = Server.getServer(ipAddress);
		Server server2 = Server.getServer(ipAddress);
	}
	
	@Test
	public void testGetIpAddressConformanceRight() throws ExistentServerException {
		String ipAddressHome = "192.168.0.1";
		server = Server.getServer(ipAddressHome);
		assertEquals("Test with correct values", ipAddressHome, server.getIpAddress());
	}

}
