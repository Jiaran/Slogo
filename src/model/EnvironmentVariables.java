package model;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentVariables {
	private Map<String, Double> myVariables;

	public EnvironmentVariables() {
		myVariables = new HashMap<String, Double>();
	}

	public EnvironmentVariables(Map<String, Double> setVariables){
		myVariables = setVariables;
	}

	public void addVariable(String name, double value) {
		myVariables.put(name, value);
	}
	
	public double getVariable(String name) {
		if (myVariables.containsKey(name))
			return myVariables.get(name);
		return 0;
	}

	public boolean isAVariable(String s) {
		return myVariables.containsKey(s);
	}

	public Map<String, Double> getVariables() {
		Map<String, Double> ret = new HashMap<String, Double>();
		for(String s: myVariables.keySet()){
			ret.put(s, myVariables.get(s));
		}
		
		return ret;
	}
}
