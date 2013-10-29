package akilliyazilim.android.lifecycle;

import Utils.LifeCycleTracker;
import Utils.ViewTracker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity {

	LifeCycleTracker lct;
	TextView method_list;
	TextView status_list;
	Button change_activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		method_list = (TextView) findViewById(R.id.textView3);
		status_list = (TextView) findViewById(R.id.textView4);
		change_activity = (Button) findViewById(R.id.button1);
		
		
		lct = LifeCycleTracker.getInstance();
		lct.setStatus("Activity2", "onCreate");
		ViewTracker.setView(method_list, status_list);
		
		change_activity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Activity2.this,Activity1.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	protected void onDestroy() {
		lct.setStatus("Activity2", "onDestroy");
		ViewTracker.setView(method_list, status_list);
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		lct.setStatus("Activity2", "onPause");
		ViewTracker.setView(method_list, status_list);
		super.onPause();
	}

	@Override
	protected void onRestart() {
		lct.setStatus("Activity2", "onRestart");
		ViewTracker.setView(method_list, status_list);
		super.onRestart();
	}

	@Override
	protected void onResume() {
		lct.setStatus("Activity2", "onResume");
		ViewTracker.setView(method_list, status_list);
		super.onResume();
	}

	@Override
	protected void onStart() {
		lct.setStatus("Activity2", "onStart");
		ViewTracker.setView(method_list, status_list);
		super.onStart();
	}

	@Override
	protected void onStop() {
		lct.setStatus("Activity2", "onStop");
		ViewTracker.setView(method_list, status_list);
		super.onStop();
	}
	
	

}
