package model;

public class Arg {
	private String stringValue;
	private double doubleValue;
	private int intValue;

	// when the argument is getting a variable
	public Arg(String s, EnvironmentVariables envVars, State state) {
		stringValue = s;
		if (envVars.isAVariable(s)) {
			doubleValue = envVars.getVariable(s);
			intValue = (int) envVars.getVariable(s);
		} else {
			state.setError("No variable " + s + " found.");
		}
	}

	public Arg(double d) {
		stringValue = String.valueOf(d);
		doubleValue = d;
		intValue = (int) d;
	}
	
	// when the argument is setting a variable
	public Arg(String s) {
		stringValue = s;
	}

	public String getStringArg() {
		return stringValue;
	}

	public double getDoubleArg() {
		return doubleValue;
	}

	public int getIntArg() {
		return intValue;
	}
}
