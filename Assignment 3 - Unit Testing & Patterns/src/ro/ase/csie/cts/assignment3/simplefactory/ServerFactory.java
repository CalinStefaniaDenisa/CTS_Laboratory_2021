package ro.ase.csie.cts.assignment3.simplefactory;

import ro.ase.csie.cts.assignment3.ServerInterface;
import ro.ase.csie.cts.assignment3.exceptions.ServerTypeException;

public class ServerFactory {
	
	public static ServerInterface createServer (ServerType type, String ipAddress) throws ServerTypeException {
		
		ServerInterface server = null;
		switch(type) {
		case WEB:
			server = new ServerWeb(ipAddress);
			break;
		case DNS:
			server = new ServerDNS();
		default:
			throw new ServerTypeException();
		}
		return server;
	}

}
