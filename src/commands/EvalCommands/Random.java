package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns a random number less than Arg1
 */
public class Random extends EvalCommand {

	public Random(State state) {
		super(1, state, "Random");
	}

	/**
	 * @return a random number less than Arg1
	 */
	public double doCommand() {
		return Math.random() * myArgs.get(0).getDoubleArg();
	}
}
