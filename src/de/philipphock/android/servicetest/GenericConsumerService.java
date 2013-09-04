package de.philipphock.android.servicetest;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public abstract class GenericConsumerService extends Service{
	private volatile boolean isAlreadyRunning=false;

	
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//called every time startService is called, even if the service is already running
		//return super.onStartCommand(intent, flags, startId);
		
		if (!isAlreadyRunning){
			start();
		}else{
			Log.d("Service","already started");
		}
		return Service.START_NOT_STICKY;
	}
	
	
	private void start(){
		isAlreadyRunning = true;
		Thread t = new Thread(newInstance(this));
		t.start();
	}
	
	public abstract Runnable newInstance(GenericConsumerService service);
	

	

}
