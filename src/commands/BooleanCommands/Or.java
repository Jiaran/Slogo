package commands.BooleanCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * returns 1 if Arg 1 or Arg 2 is non-zero, 0 otherwise
 */
public class Or extends BooleanCommand {

	public Or(State state) {
		super(2, state, "Or");
	}

	/**
	 * @return 1 if Arg 1 or Arg 2 is non-zero, 0 otherwise
	 */
	public double doCommand() {

		if (myArgs.get(0).getDoubleArg() > 0
				|| myArgs.get(1).getDoubleArg() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
