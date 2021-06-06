package ro.ase.csie.cts.assignment3.prototype;

import java.util.ArrayList;
import java.util.Random;

import ro.ase.csie.cts.assignment3.ServerInterface;
import ro.ase.csie.cts.assignment3.exceptions.ExistentServerException;

public class Server implements ServerInterface, Cloneable {
	
	String ipAddress;
	int port;
	int maxConnections;
	
	ArrayList<Integer> connections = new ArrayList<>();

	
	private Server() {
		System.out.println("Creating an empty Server object...");
		
	}
	
	public Server(String ipAddress, int port, int maxConnections) {
		System.out.println("Loading...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.connections = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < maxConnections; i++) {
			this.connections.add(random.nextInt(1000));
		}

		this.ipAddress = ipAddress;
		this.port = port;
		this.maxConnections = maxConnections;
	}

	@Override
	public Object clone() {
		Server copy = new Server();
		copy.ipAddress = this.ipAddress;
		copy.port = this.port;
		copy.maxConnections = this.maxConnections;
		
		copy.connections = (ArrayList<Integer>) this.connections.clone();
		return copy;
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
		return (this.connections != null);
	}

	@Override
	public boolean disconnect() {
		System.out.println("Disconnected from server.");
		return (this.connections == null);
	}

}
