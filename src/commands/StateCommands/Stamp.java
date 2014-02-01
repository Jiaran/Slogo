package commands.StateCommands;

import model.State;

/**
 * No arguments are needed. doCommand() "stamps" an image of the turtle in its
 * current settings on the workspace display
 */
public class Stamp extends StateCommand {

	public Stamp(State state) {
		super(0, state, "Stamp");
	}

	/**
	 * "stamps" an image of the turtle in its current settings on the workspace
	 * display
	 * 
	 * @return 0
	 */
	@Override
	public double doCommand() {
		myStateRef.addStamps();
		return 0;
	}
}
