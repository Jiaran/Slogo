package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns the remainder of Arg1 divided by Arg2
 */
public class Remainder extends EvalCommand {

	public Remainder(State state) {
		super(2, state, "Remainder");
	}

	/**
	 * @return the remainder of Arg1 divided by Arg2
	 */
	public double doCommand() {
		return myArgs.get(0).getDoubleArg() % myArgs.get(1).getDoubleArg();
	}
}
