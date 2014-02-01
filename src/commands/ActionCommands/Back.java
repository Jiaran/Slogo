package commands.ActionCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() moves
 * the turtle back in its current heading by a distance specified by Arg 1 and
 * returns the value of Arg 1
 */
public class Back extends ActionCommand {
	public Back(State state) {
		super(1, state, "Backward");
	}

	/**
	 * Move the turtle back in its current heading by a distance specified by
	 * Arg 1
	 * 
	 * @return the double value of Arg 1
	 */
	public double doCommand() {
		double mag = myArgs.get(0).getDoubleArg();

		myStateRef.setNotification("Moved turtle back " + mag);
		myStateRef.moveForward(-1 * mag);
		return mag;
	}
}
