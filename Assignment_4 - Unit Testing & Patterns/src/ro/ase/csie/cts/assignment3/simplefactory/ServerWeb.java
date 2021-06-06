package ro.ase.csie.cts.assignment3.simplefactory;

import ro.ase.csie.cts.assignment3.ServerInterface;

public class ServerWeb implements ServerInterface {

	String ipAddress;
	
	
	public ServerWeb(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String getIpAddress() {
		return this.ipAddress;
	}

	@Override
	public int getPort() {
		return 2020;
	}

	@Override
	public int getMaxConnections() {
		return 2;
	}

	@Override
	public boolean connect() {
		System.out.println("Connected to server Web.");
		return false;
	}

	@Override
	public boolean disconnect() {
		System.out.println("Disconnected from server Web.");
		return false;
	}

}
