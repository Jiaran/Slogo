package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns the quotient of Arg1 and Arg2 (Arg1/Arg2)
 */
public class Quotient extends EvalCommand {

	public Quotient(State state) {
		super(2, state, "Quotient");
	}

	/**
	 * @return the quotient of Arg1 and Arg2 (Arg1/Arg2)
	 */
	public double doCommand() {
		return myArgs.get(0).getDoubleArg() / myArgs.get(1).getDoubleArg();
	}
}
