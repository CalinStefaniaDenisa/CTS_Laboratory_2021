package ro.ase.csie.cts.assignment3;

public interface ServerInterface {
	public String getIpAddress();
    public int getPort();
    public int getMaxConnections();

    public boolean connect();
    public boolean disconnect();
}
