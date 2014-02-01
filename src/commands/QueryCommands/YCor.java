package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns the y-coordinate of the most recently active turtle
 */
public class YCor extends QueryCommand {

	public YCor(State state) {
		super(0, state, "YCoordinate");
	}
	/**
	 * @return the y-coordinate of the most recently active turtle
	 */
	@Override
	public double doCommand() {
		return myStateRef.getY();
	}
}
