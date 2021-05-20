package ro.csie.cts.g1093.dp.observer;

import com.sun.jdi.connect.spi.Connection;

public class BackupModule implements ConnectionStatusInterface {

	@Override
	public void connectionUp() {
		System.out.println("Connection is restored.");
		
	}

	@Override
	public void connectionDown() {
		System.out.println("Restoring connection...");
		
	}

}
