package commands;

import java.util.ArrayList;
import java.util.List;

import model.Arg;
import model.State;

/**
 * Commands are the actionable interpretation of strings that the SLOGO user
 * types in that can change the program's state. They can take in multiple
 * arguments (Arg objects), which are added by calling addArg. They also have a
 * set number of arguments.
 */

public abstract class Command {
	protected int myArgNum;
	protected boolean isCreation;
	protected List<String> myCallers;
	protected List<Arg> myArgs;
	protected State myStateRef;

	public Command(int argNum, State state, String caller) {
		myArgNum = argNum;
		myCallers = new ArrayList<String>();
		myArgs = new ArrayList<Arg>();
		myStateRef = state;
		isCreation = false;
		if(caller != ""){
			makeCallers(caller);
		}
	}

	private void makeCallers(String caller){
		String[] myArray = myStateRef.getRB().getString(caller).split(",");
		for(String s: myArray){
			myCallers.add(s);
		}
	}
	
	public int getArgNum() {
		return myArgNum;
	}

	public boolean isCreation(){
		return isCreation && myArgs.isEmpty();
	}
	
	public List<String> getCallers() {
		return myCallers;
	}

	public void addArg(Arg a) {
		myArgs.add(a);
	}

	public abstract double doCommand();

	/**
	 * Checks to see whether the command has enough arguments to execute
	 * properly.
	 * 
	 * @return boolean
	 */

	public boolean canExecute() {
		return myArgNum == myArgs.size();
	}
}
