package Utils;

import java.util.ArrayList;

import android.os.Handler;
import android.widget.TextView;

public class ViewTracker {
	
	private static LifeCycleTracker life_cycle_tracker = LifeCycleTracker.getInstance();
	
	
	
	public static void setView(final TextView methods_textview,final TextView hashmap_textview) {

			Handler handler = new Handler();
			handler.postDelayed(new Runnable()
			{
				@Override
				public void run() {
					
					StringBuilder methods_sb = new StringBuilder();
					ArrayList<String> method_list = life_cycle_tracker.getMethodsList();
					
					for (int i = 0; i < method_list.size(); i++) {
						
						String method = method_list.get(i);
						methods_sb.insert(0, method + "\n");
					}
					methods_textview.setText(methods_sb);
					
					
					StringBuilder hasmap_sb = new StringBuilder();
					for (String activity_name : life_cycle_tracker.getKeyset()) {
						hasmap_sb.insert(0, activity_name + ":" + life_cycle_tracker.getStatus(activity_name)+"\n");
					}
					
					hashmap_textview.setText(hasmap_sb);
					
				}
			}, 750);
		
		
	}

}
