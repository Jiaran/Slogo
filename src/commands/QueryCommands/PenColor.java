package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns the pen's current color index
 */
public class PenColor extends QueryCommand {

	public PenColor(State state) {
		super(0, state, "GetPenColor");
	}
	/**
	 * @return the pen's current color index
	 */
	@Override
	public double doCommand() {
		return myStateRef.getColorIndex();
	}
}
