package ro.ase.csie.cts.assignment3.simplefactory.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.assignment3.ServerInterface;
import ro.ase.csie.cts.assignment3.exceptions.ExistentServerException;
import ro.ase.csie.cts.assignment3.exceptions.ServerTypeException;
import ro.ase.csie.cts.assignment3.prototype.Server;
import ro.ase.csie.cts.assignment3.simplefactory.ServerFactory;
import ro.ase.csie.cts.assignment3.simplefactory.ServerType;

public class TestServer {
	
	ServerFactory factory = new ServerFactory();
	ServerInterface server;
	String ipAddress = "10.10.10.1";

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

	@Test(expected = NullPointerException.class)
	public void testServerTypeErrorConditions() throws ServerTypeException {
		server = ServerFactory.createServer(null, ipAddress);
	}
	
	@Test
	public void testServerWebConformance() throws ServerTypeException {
		server = ServerFactory.createServer(ServerType.WEB, ipAddress);
		assertEquals("Test with correct values", ipAddress, server.getIpAddress());
	}

}
