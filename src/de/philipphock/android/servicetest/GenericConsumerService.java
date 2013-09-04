package de.philipphock.android.servicetest;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


public abstract class GenericConsumerService<E extends Runnable> extends Service{
	private volatile boolean isAlreadyRunning=false;
	private final IBinder myBinder = new MyBinder();
	
	public static final String SERVICE_STATE="SERVICE_STATE";
	public static final int SERVICE_STATE_FINISHED=1;
	public static final int SERVICE_STATE_ABORTED=2;
	
	private E task;
	
	protected E getTask(){
		return task;
	}
	
	
	public void onFinish(){
		Intent intent = new Intent(SERVICE_STATE);
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
		stopSelf();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return myBinder;
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
		this.task = newInstance(this);
		Thread t = new Thread(this.task);
		t.start();
	}
	
	public abstract E newInstance(GenericConsumerService<E> service);
	

	public class MyBinder extends Binder{
		
		@SuppressWarnings("rawtypes")
		GenericConsumerService getService(){
			
			return GenericConsumerService.this; 
		}
	}
	

}
