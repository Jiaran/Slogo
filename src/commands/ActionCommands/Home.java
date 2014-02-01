package commands.ActionCommands;

import model.State;

/**
 * No arguments are needed. doCommand() moves the turtle to its home position
 */
public class Home extends ActionCommand {
	public Home(State state) {
		super(0, state, "Home");
	}

	/**
	 * Moves the turtle to its home position
	 * 
	 * @return the distance turtle moved
	 */
	public double doCommand() {
		myStateRef
				.setNotification("The turtle has been moved to the home position");
		
		return myStateRef.resetPosition();
	}
}
