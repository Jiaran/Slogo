package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand()
 * returns tan(Arg1)
 */
public class Tan extends EvalCommand {

	public Tan(State state) {
		super(1, state, "Tangent");
	}
	/**
	 * @return tan(Arg1)
	 */
	public double doCommand() {
		if (myArgs.get(0).getDoubleArg() == 0) {
			return 0;
		} else {
			return Math.tan(2 * Math.PI * myArgs.get(0).getDoubleArg() / 360);
		}
	}
}
