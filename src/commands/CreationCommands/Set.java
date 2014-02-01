package commands.CreationCommands;

import model.EnvironmentVariables;
import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * assigns the value of Arg2 to the variable Arg1, creating the variable if
 * necessary
 */
public class Set extends CreationCommand {
	EnvironmentVariables myEnvVarRef;

	public Set(State state) {
		super(2, state, "MakeVariable");
		myEnvVarRef = state.getEnvVarRef();
		;
	}

	/**
	 * Assigns the value of Arg2 to the variable Arg1, creating the variable if
	 * necessary
	 * 
	 * @return the value of Arg2
	 */
	@Override
	public double doCommand() {
		myEnvVarRef.addVariable(myArgs.get(0).getStringArg(), myArgs.get(1)
				.getDoubleArg());
		myStateRef.setNotification("Set " + myArgs.get(0).getStringArg()
				+ " to " + myArgs.get(1).getStringArg());
		return myArgs.get(1).getDoubleArg();
	}
}
