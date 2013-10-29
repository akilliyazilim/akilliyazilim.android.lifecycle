package akilliyazilim.android.lifecycle;

import Utils.LifeCycleTracker;
import Utils.ViewTracker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends Activity {
	
	LifeCycleTracker lct;
	TextView method_list;
	TextView status_list;
	Button change_activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		method_list = (TextView) findViewById(R.id.textView3);
		status_list = (TextView) findViewById(R.id.textView4);
		change_activity = (Button) findViewById(R.id.button1);
		
		
		lct = LifeCycleTracker.getInstance();
		lct.setStatus("Activity1", "onCreate");
		ViewTracker.setView(method_list, status_list);
		
		change_activity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Activity1.this,Activity2.class);
				startActivity(i);
				
			}
		});
		
	}
	
	@Override
	protected void onDestroy() {

		lct.setStatus("Activity1", "onDestroy");
		ViewTracker.setView(method_list, status_list);
		super.onDestroy();
	}



	@Override
	protected void onPause() {

		lct.setStatus("Activity1", "onPause");
		ViewTracker.setView(method_list, status_list);
		super.onPause();
	}



	@Override
	protected void onRestart() {

		lct.setStatus("Activity1", "onRestart");
		ViewTracker.setView(method_list, status_list);
		super.onRestart();
	}



	@Override
	protected void onResume() {

		lct.setStatus("Activity1", "onResume");
		ViewTracker.setView(method_list, status_list);
		super.onResume();
	}



	@Override
	protected void onStart() {

		lct.setStatus("Activity1", "onStart");
		ViewTracker.setView(method_list, status_list);
		super.onStart();
	}



	@Override
	protected void onStop() {

		lct.setStatus("Activity1", "onStop");
		ViewTracker.setView(method_list, status_list);
		super.onStop();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lifecycle_test, menu);
		return true;
	}

	
}
