package commands.StateCommands;

import commands.ActionCommands.ActionCommand;

import model.State;

/**
 * No arguments are needed. doCommand() sets the pen status to up
 */
public class PenUp extends ActionCommand {

	public PenUp(State state) {
		super(0, state, "PenUp");
	}

	/**
	 * sets the pen status to up
	 * 
	 * @return 0
	 */
	public double doCommand() {
		myStateRef.setPenIsDown(false);
		myStateRef.setNotification("The turtle's pen is up");
		return 0;
	}
}
