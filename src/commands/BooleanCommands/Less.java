package commands.BooleanCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * returns 1 if Arg 1 is less than Arg 2, 0 otherwise
 */
public class Less extends BooleanCommand {

	public Less(State state) {
		super(2, state, "LessThan");
	}

	/**
	 * @return 1 if Arg 1 is less than Arg 2, 0 otherwise
	 */
	public double doCommand() {
		if (myArgs.get(0).getDoubleArg() < myArgs.get(1).getDoubleArg()) {
			return 1;
		} else {
			return 0;
		}
	}
}
