package commands.ActionCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand() sets
 * the heading of the turtle towards a position (Arg1, Arg2)
 */
public class Towards extends ActionCommand {

	public Towards(State state) {
		super(2, state, "SetTowards");
	}

	/**
	 * Sets the heading of the turtle towards a position (Arg1, Arg2)
	 * 
	 * @return the number of degrees turned
	 */
	public double doCommand() {
		myStateRef.setNotification("The turtle is now facing towards ("
				+ myArgs.get(0).getDoubleArg() + ", "
				+ myArgs.get(1).getDoubleArg() + ")");
		return myStateRef.turnTowards(myArgs.get(0).getDoubleArg(),
				myArgs.get(1).getDoubleArg());
	}
}
