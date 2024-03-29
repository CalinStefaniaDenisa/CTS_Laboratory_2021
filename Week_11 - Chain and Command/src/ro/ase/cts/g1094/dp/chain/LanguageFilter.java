package ro.ase.cts.g1094.dp.chain;

public class LanguageFilter extends ChatHandler {
	
	String language;
	public static String[] forbiddenWords = new String[] {"hate", "attack", "kill"};
	

	public LanguageFilter(String language) {
		super();
		this.language = language;
	}
	
	
	@Override
	public void processMessage(Message msg) {
		boolean isOk = true;
		for(String word : forbiddenWords) {
			if(msg.text.toLowerCase().contains(word)) {
				isOk = false;
				break;
			}
		}
		
		if(!isOk) {
			System.out.println("Message not allowed !");
		}
		else {
			if(this.next != null) {
				this.next.processMessage(msg);
			}
		}
		
	}

}
