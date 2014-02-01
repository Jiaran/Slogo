package commands.EvalCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand()
 * returns the product of Arg1 and Arg2
 */
public class Product extends EvalCommand {

	public Product(State state) {
		super(2, state, "Product");
	}

	/**
	 * @return the product of Arg1 and Arg2
	 */
	public double doCommand() {
		return myArgs.get(0).getDoubleArg() * myArgs.get(1).getDoubleArg();
	}
}
