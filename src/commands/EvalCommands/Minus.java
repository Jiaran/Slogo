package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() returns
 * Arg1 multiplied by negative 1
 */
public class Minus extends EvalCommand {

	public Minus(State state) {
		super(1, state, "Minus");
	}

	/**
	 * @return Arg1*(-1)
	 */
	public double doCommand() {
		return -1 * myArgs.get(0).getDoubleArg();
	}
}
