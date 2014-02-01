package commands.StateCommands;

import model.State;

/**
 * No arguments are needed. doCommand() removes all stamps that have been made
 */
public class ClearStamps extends StateCommand {

	public ClearStamps(State state) {
		super(0, state, "ClearStamps");
	}

	/**
	 * removes all stamps that have been made
	 * 
	 * @return 0
	 */
	@Override
	public double doCommand() {
		myStateRef.clearStamps();
		return 0;
	}
}
