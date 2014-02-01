package commands.ActionCommands;

import model.State;
/**
 * No arguments are needed. doCommand() sets the visibility of the turtle to true
 */
public class ShowTurtle extends ActionCommand {
	public ShowTurtle(State state) {
		super(0, state, "ShowTurtle");
	}
	/**
	 * Sets the visibility of the turtle to true
	 * 
	 * @return 1
	 */
	public double doCommand() {
		myStateRef.setVisibility(true);
		myStateRef.setNotification("The turtle is now visible");
		return 1;
	}
}