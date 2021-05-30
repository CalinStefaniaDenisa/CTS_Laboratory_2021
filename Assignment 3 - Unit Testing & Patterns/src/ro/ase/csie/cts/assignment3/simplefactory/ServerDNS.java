package ro.ase.csie.cts.assignment3.simplefactory;

import ro.ase.csie.cts.assignment3.ServerInterface;

public class ServerDNS implements ServerInterface {

	String ipAddress;
	int port;
	
	public ServerDNS() {
		this.ipAddress = "172.16.254.1";
		this.port = 8080;
	}

	@Override
	public String getIpAddress() {
		return "172.16.254.1";
	}

	@Override
	public int getPort() {
		return 8080;
	}

	@Override
	public int getMaxConnections() {
		return 5;
	}

	@Override
	public boolean connect() {
		System.out.println("Connected to server DNS.");
		return true;
	}

	@Override
	public boolean disconnect() {
		System.out.println("Disconnected from server DNS.");
		return true;
	}

}
