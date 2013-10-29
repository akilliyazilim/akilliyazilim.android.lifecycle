package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LifeCycleTracker {
	
	private HashMap<String, String> status_hashmap;
	private ArrayList<String> status_method;
	
	private static LifeCycleTracker lct;
	
	public static LifeCycleTracker getInstance()
	{
		if(lct==null)
			lct = new LifeCycleTracker();
		return lct;
	}
	
	public LifeCycleTracker()
	{
		status_hashmap = new HashMap<String, String>();
		status_method = new ArrayList<String>();
	}
	
	public void setStatus(String activiy_name,String method)
	{
		status_method.add(activiy_name + "." + method + "();");
		if(status_hashmap.containsKey(activiy_name))
			status_hashmap.remove(activiy_name);
		status_hashmap.put(activiy_name, method);
	}
	
	public ArrayList<String> getMethodsList()
	{
		return status_method;
	}
	
	public String getStatus(String key)
	{
		String status;
		String suffix = "ed";
		
		status = status_hashmap.get(key);
		
		if(status.endsWith("e"))
			status +="d";
		else if(status.endsWith("p"))
			status += "p"+suffix;
		else
			status += suffix;
		
		return status;
	}
	
	public Set<String> getKeyset()
	{
		return status_hashmap.keySet();
	}

}
