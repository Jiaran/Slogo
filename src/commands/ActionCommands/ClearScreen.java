package commands.ActionCommands;

import model.State;

/**
 * No arguments are needed. doCommand() resets the turtle's position, clears all
 * trails, and returns the distance turtle moved
 */
public class ClearScreen extends ActionCommand {
	public ClearScreen(State state) {
		super(0, state, "ClearScreen");
	}

	/**
	 * Resets the turtle's position, clears all trails
	 * 
	 * @return the distance turtle moved
	 */
	public double doCommand() {
		double movementMag = myStateRef.resetPosition();
		myStateRef.clearTrails();
		myStateRef
				.setNotification("Cleared the screen and sent the turtle to the home position");
		return movementMag;
	}
}
