package commands.BooleanCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add one argument to this command. doCommand()
 * returns 1 if Arg 1 is equal to zero, 0 otherwise
 */
public class Not extends BooleanCommand {

	public Not(State state) {
		super(1, state, "Not");
	}

	/**
	 * @return 1 if Arg 1 is equal to 0, 0 otherwise
	 */
	public double doCommand() {
		if (myArgs.get(0).getDoubleArg() == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}