package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() returns
 * the natural log of Arg1
 */

public class Log extends EvalCommand {

	public Log(State state) {
		super(1, state, "NaturalLog");
	}

	/**
	 * @return the natural log of Arg1
	 */
	public double doCommand() {
		return Math.log(myArgs.get(0).getDoubleArg());
	}
}
