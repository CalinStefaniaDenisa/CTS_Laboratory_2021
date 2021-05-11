package ro.ase.cts.g1094.dp.command;

public class BackupModule implements GameModulesInterface {

	@Override
	public void doTask(String taskName) {
		System.out.println("Backing up data: " + taskName);
		
	}

}
