package ro.ase.cts.g1094.dp.command;

public class AsyncTask implements AsyncTaskInterface {
	
	String taskName;
	int priority;
	GameModulesInterface module;
	

	public AsyncTask(String taskName, int priority, GameModulesInterface module) {
		super();
		this.taskName = taskName;
		this.priority = priority;
		this.module = module;
	}


	@Override
	public void awaitTask() {
		this.module.doTask(taskName);
		
	}

}
