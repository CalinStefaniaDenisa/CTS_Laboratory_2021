package ro.ase.csie.cts.g1094.dp.facade;

public class UserAPIFacade {
	
	public static UserProfile getUserProfile(String serverIP, String username, String pass) {
		
		GameServer gameServer = new GameServer();
		gameServer.connect(serverIP);
		if(gameServer.isConnected()) {
			UserAccount user = new UserAccount();
			user.login(username, pass);	
			
			UserProfile profile = user.downloadUserProfile();
			profile.getUserProfile();
			return profile;
		} else {
			return null;
		}
	}
}
