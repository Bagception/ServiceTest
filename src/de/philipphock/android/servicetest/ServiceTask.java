package de.philipphock.android.servicetest;

import android.os.SystemClock;
import android.util.Log;

public class ServiceTask implements Runnable{

	private final GenericConsumerService<ServiceTask> service;
	private int tick;
	public ServiceTask(GenericConsumerService<ServiceTask> service) {
		this.service = service;
	}
	
	public int getTick(){
		return tick;
	}
	
	@Override
	public void run() {
		for (int i = 0;i < 10; i++){
			SystemClock.sleep(1000);
			Log.d("Service","Service tick "+i);
			tick=i;
		}
		service.onFinish();
	}

}
