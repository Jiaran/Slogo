package commands.ActionCommands;

import model.State;

/**
 * No arguments are needed. doCommand() sets the visibility of the turtle to
 * false
 */
public class HideTurtle extends ActionCommand {
	public HideTurtle(State state) {
		super(0, state, "HideTurtle");
	}

	/**
	 * Sets the visibility of the turtle to false
	 * 
	 * @return 0
	 */
	public double doCommand() {
		myStateRef.setVisibility(false);
		myStateRef.setNotification("The turtle is now hidden");
		return 0;
	}
}