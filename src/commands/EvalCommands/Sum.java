package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns the sum of Arg1 and Arg2
 */
public class Sum extends EvalCommand {

	public Sum(State state) {
		super(2, state, "Sum");
	}
	/**
	 * @return the sum of Arg1 and Arg2
	 */
	public double doCommand() {
		return myArgs.get(0).getDoubleArg() + myArgs.get(1).getDoubleArg();
	}
}
