package commands.StateCommands;

import commands.ActionCommands.ActionCommand;

import model.State;

/**
 * No arguments are needed. doCommand() sets the pen status to down
 */
public class PenDown extends ActionCommand {

	public PenDown(State state) {
		super(0, state, "PenDown");
	}

	/**
	 * sets the pen status to down
	 * 
	 * @return 1
	 */
	public double doCommand() {
		myStateRef.setPenIsDown(true);
		myStateRef.setNotification("The turtle's pen is down");
		return 1;
	}
}
