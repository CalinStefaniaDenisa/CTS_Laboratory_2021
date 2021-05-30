package ro.ase.csie.cts.assignment3.singleton;

import java.util.ArrayList;
import java.util.Hashtable;

import ro.ase.csie.cts.assignment3.ServerInterface;
import ro.ase.csie.cts.assignment3.exceptions.ExistentServerException;

public class Server implements ServerInterface {
	
	String ipAddress;
	int port;
	int maxConnections;
	
	private static Hashtable<String, Server> servers = new Hashtable<>();
	
	private Server() {
		System.out.println("Creating a connection object");
		System.out.println("Loading configuration.....");
		this.ipAddress = "172.16.254.1";
		this.port = 443;
		this.maxConnections = 1;
	}
	
	private Server(String ipAddress) {
		System.out.println("Creating a connection object");
		System.out.println("Loading configuration.....");
		this.ipAddress = ipAddress;
		this.port = 443;
		this.maxConnections = 1;
	}

	@Override
	public String getIpAddress() {
		return this.ipAddress;
	}

	@Override
	public int getPort() {
		return this.port;
	}

	@Override
	public int getMaxConnections() {
		return this.maxConnections;
	}

	@Override
	public boolean connect() {
		System.out.println("Connected to server.");
		return (this.servers != null);
	}

	@Override
	public boolean disconnect() {
		System.out.println("Disconnected from server.");
		return (this.servers == null);
	}
	
	public static synchronized Server getServer(String ipAddress) throws ExistentServerException {
		Server server = servers.get(ipAddress);
		if (server == null) {
			server = new Server(ipAddress);
			servers.put(ipAddress, server);
		} else {
			throw new ExistentServerException();
		}
		return server;
	}

}
