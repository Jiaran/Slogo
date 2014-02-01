package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand()
 * returns sin(Arg 1)
 */
public class Sin extends EvalCommand {

	public Sin(State state) {
		super(1, state, "Sine");
	}
	/**
	 * @return sin(Arg1)
	 */
	public double doCommand() {
		return Math.sin(2 * Math.PI * myArgs.get(0).getDoubleArg() / 360);
	}
}
