package commands.BooleanCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * returns 1 if Arg 1 is not equal to Arg 2, 0 otherwise
 */
public class NotEqual extends BooleanCommand {

	public NotEqual(State state) {
		super(2, state, "NotEqual");
	}

	/**
	 * @return 1 if Arg 1 is not equal to Arg 2, 0 otherwise
	 */
	public double doCommand() {
		if (myArgs.get(0).getDoubleArg() != myArgs.get(1).getDoubleArg()) {
			return 1;
		} else {
			return 0;
		}
	}
}