package de.philipphock.android.servicetest;

import de.philipphock.android.lib.services.ServiceUtil;
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
		updateServiceUIState();
			
			
	}
	
	private void updateServiceUIState(){
		Button onStartStopServiceButton = (Button) findViewById(R.id.startstopservice);
		if (ServiceUtil.isServiceRunning(this, ServiceTaskService.class)){
			onStartStopServiceButton.setText("stop service");
		}else{
			onStartStopServiceButton.setText("start service");
		}		
	}
	

	public void onStartStopService(View v){
		Intent i = new Intent(this,ServiceTaskService.class);
		if (ServiceUtil.isServiceRunning(this, ServiceTaskService.class)){
			stopService(i);
		}else{
			startService(i);
		}
		updateServiceUIState();
	}
}
