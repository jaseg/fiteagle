package org.fiteagle.adapter.stopwatch;



import java.util.List;

import org.fiteagle.adapter.common.InMemoryResourceDatabase;
import org.fiteagle.adapter.common.ResourceAdapter;
import org.fiteagle.adapter.common.ResourceProperties;


public class StopwatchAdapter extends ResourceAdapter {

	
	private transient boolean runningState = false;

	public StopwatchAdapter(){
		this.resourceDatabase = new InMemoryResourceDatabase();
		this.setId("StopWatchAdapter"); 
		this.create();
	}
	public boolean isRunning() {
		return runningState;
	}

	@Override
	public void stop() {
		this.runningState = false;
	}

	@Override
	public void start() {
		this.runningState=true;
		
	}

	@Override
	public void create() {
	
		ResourceProperties props = new StopWatchInstanceProperties();
		props.setIdentifier("myStopWatchInstance");
		props.setName("StopWatch");
		this.resourceDatabase.addResource(props);
		
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getStatus() {
		return "Is running: "+runningState;
	}
	@Override
	public List<ResourceProperties> getAllResources() {
		return resourceDatabase.getResources();
	}
	
	
}