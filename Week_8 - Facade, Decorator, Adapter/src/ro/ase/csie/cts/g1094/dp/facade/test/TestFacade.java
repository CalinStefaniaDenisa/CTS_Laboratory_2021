package ro.ase.csie.cts.g1094.dp.facade.test;

import ro.ase.csie.cts.g1094.dp.facade.GameServer;
import ro.ase.csie.cts.g1094.dp.facade.UserAPIFacade;
import ro.ase.csie.cts.g1094.dp.facade.UserAccount;
import ro.ase.csie.cts.g1094.dp.facade.UserProfile;

public class TestFacade {

	public static void main(String[] args) {

		GameServer gameServer = new GameServer();
		gameServer.connect("10.0.0.1");
		if(gameServer.isConnected()) {
			UserAccount user = new UserAccount();
			user.login("Player 1", "1234");	
			
			UserProfile profile = user.downloadUserProfile();
			profile.getUserProfile();
		}
		
		GameServer gameServer2 = new GameServer();
		gameServer2.connect("10.0.0.1");
		if(gameServer2.isConnected()) {
			UserAccount user = new UserAccount();
			user.login("Player 2", "1234");	
			
			UserProfile profile = user.downloadUserProfile();
			profile.getUserProfile();
		}
		
		
		UserProfile player1Profile = UserAPIFacade.getUserProfile("10.0.0.1", "Player 1", "1234");
		if(player1Profile != null) {
			player1Profile.getUserProfile();
		}
	}

}
