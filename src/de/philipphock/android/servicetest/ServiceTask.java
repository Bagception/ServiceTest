package de.philipphock.android.servicetest;

import android.os.SystemClock;
import android.util.Log;

public class ServiceTask implements Runnable{

	private final GenericConsumerService service;
	
	public ServiceTask(GenericConsumerService service) {
		this.service = service;
	}
	
	
	@Override
	public void run() {
		for (int i = 0;i < 10; i++){
			SystemClock.sleep(1000);
			Log.d("Service","Service tick "+i);
		}
		service.onFinish();
	}

}
