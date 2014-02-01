package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns 1 if the turtle is visible, 0 if the turtle is not
 */
public class ShowingP extends QueryCommand {

	public ShowingP(State state) {
		super(0, state, "IsShowing");
	}
	/**
	 * @return 1 if the turtle is visible, 0 if the turtle is not
	 */
	@Override
	public double doCommand() {
		boolean status = myStateRef.getVisibility();
		if (status)
			return 1;
		return 0;
		// also silly
	}
}
