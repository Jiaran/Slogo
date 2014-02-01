package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() returns
 * the cos(Arg1)
 */
public class Cos extends EvalCommand {

	public Cos(State state) {
		super(1, state, "Cosine");
	}

	/**
	 * @return cos(Arg1)
	 */
	public double doCommand() {
		return Math.cos(2 * Math.PI * myArgs.get(0).getDoubleArg() / 360);
	}
}
