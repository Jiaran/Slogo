package commands.BooleanCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * returns 1 if Arg 1 and Arg 2 are non-zero, 0 otherwise
 */
public class And extends BooleanCommand {

	public And(State state) {
		super(2, state, "And");
	}

	/**
	 * @return 1 if Arg 1 and Arg 2 are non-zero, 0 otherwise
	 */
	public double doCommand() {

		if (myArgs.get(0).getDoubleArg() > 0
				&& myArgs.get(1).getDoubleArg() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}