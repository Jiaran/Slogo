package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns (Arg1-Arg2)
 */

public class Difference extends EvalCommand {

	public Difference(State state) {
		super(2, state, "Difference");
	}

	/**
	 * @return Arg1-Arg2
	 */
	public double doCommand() {
		return myArgs.get(0).getDoubleArg() - myArgs.get(1).getDoubleArg();
	}
}
