package ro.ase.cts.g1094.dp.chain;

public abstract class ChatHandler {
	
	ChatHandler next;
	
	
	public ChatHandler getNext() {
		return next;
	}



	public void setNext(ChatHandler next) {
		this.next = next;
	}



	public abstract void processMessage(Message msg);

}
