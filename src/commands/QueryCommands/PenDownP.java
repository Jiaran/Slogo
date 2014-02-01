package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns 1 if the pen is down, 0 if the pen is up
 */
public class PenDownP extends QueryCommand {

	public PenDownP(State state) {
		super(0, state, "IsPenDown");
	}
	/**
	 * @return 1 if the pen is down, 0 if the pen is up
	 */
	@Override
	public double doCommand() {
		boolean status = myStateRef.getPenIsDown();
		if (status)
			return 1;
		return 0;
		// this is silly
	}
}
