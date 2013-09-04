package de.philipphock.android.servicetest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		Button onStartStopServiceButton = (Button) findViewById(R.id.startstopservice);
		if (serviceIsRunning()){
			onStartStopServiceButton.setText("stop");
		}else{
			onStartStopServiceButton.setText("start");
		}
			
			
	}
	
	private boolean serviceIsRunning(){
		return false;
	}
	
	public void onStartStopService(View v){
		Intent i = new Intent(this,ServiceTaskService.class);
		if (serviceIsRunning()){
			stopService(i);
		}else{
			startService(i);
		}
	}
}
