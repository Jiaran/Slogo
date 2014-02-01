package commands.ActionCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() moves
 * the turtle forward in its current heading by Arg 1 distance and returns the
 * value of Arg 1
 */
public class Forward extends ActionCommand {

	public Forward(State state) {
		super(1, state, "Forward");
	}

	/**
	 * Moves the turtle forward in its current heading by a distance specified by
	 * Arg 1
	 * 
	 * @return the double value of Arg 1
	 */
	public double doCommand() {
		double mag = myArgs.get(0).getDoubleArg();

		myStateRef.setNotification("Moved turtle forward " + mag);
		
		return myStateRef.moveForward(mag);
	}
}
