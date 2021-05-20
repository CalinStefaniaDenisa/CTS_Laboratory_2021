package ro.csie.cts.g1093.dp.observer;

public class UserNotificationModule implements ConnectionStatusInterface {

	@Override
	public void connectionUp() {
		System.out.println("Pop-up: Connection is active.");
		
	}

	@Override
	public void connectionDown() {
		System.out.println("Pop-up: Connection to the server is lost.");
		
	}

}
