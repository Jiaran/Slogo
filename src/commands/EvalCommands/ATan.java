package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() returns
 * the arctan(Arg1)
 */
public class ATan extends EvalCommand {

	public ATan(State state) {
		super(1, state, "ArcTangent");
	}

	/**
	 * @return arctan(Arg1)
	 */
	public double doCommand() {
		if (myArgs.get(0).getDoubleArg() == 0) {
			return 0;
		} else {
			return Math
					.atan((2 * Math.PI * myArgs.get(0).getDoubleArg() / 360))
					* 360 / 2 / Math.PI;
		}
	}
}