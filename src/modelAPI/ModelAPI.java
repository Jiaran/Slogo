package modelAPI;

import java.util.Locale;

import commands.Command;

import model.Arg;
import model.EnvironmentVariables;
import model.FrontToBackParser;
import model.State;

public class ModelAPI {
	private State myState;
	private EnvironmentVariables envVars;
	private State pastState;
	
	public ModelAPI() {
		envVars = new EnvironmentVariables();
		myState = new State(envVars);
	}

	public void loadCode(String s) {
		pastState = new State(myState);
		myState.clearErrors();
		FrontToBackParser p = new FrontToBackParser(myState);
		p.parseAndRun(s);
		myState.addHistory(s);
	}

	public Data getData() {
		Data ret = new Data(myState);
		return ret;
	}

	public void setThickness(int thickness) {
		myState.setPenThickness(thickness);
	}

	public void addTurtle(int turtleID) {
		myState.addTurtle(turtleID);
	}
		
	public void setLocale(Locale l){
		myState.setLocale(l);
	}
	
	public void undo(){
		myState = pastState;
	}
	
	public void onCommand(String name, int x, int y, int keycode){
		
		if(myState.getCFRef().getUserCommandMap().containsKey(name)){
			Command c = myState.getCFRef().makeCommand(name);
			if(name.equals("onclick") || name.equals("onmove")){
				c.addArg(new Arg(x));
				c.addArg(new Arg(y));
			}
			else
				c.addArg(new Arg(keycode));
			c.doCommand();
		}
	}
}
