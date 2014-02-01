package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns Arg1 raised to the power Arg2
 */

public class Pow extends EvalCommand {

	public Pow(State state) {
		super(2, state, "Power");
	}

	/**
	 * @return Arg1 raised to the power Arg2
	 */
	public double doCommand() {
		return Math.pow(myArgs.get(0).getDoubleArg(), myArgs.get(1)
				.getDoubleArg());
	}
}
