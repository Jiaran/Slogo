package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns the x-coordinate of the most recently active turtle
 */
public class XCor extends QueryCommand {

	public XCor(State state) {
		super(0, state, "XCoordinate");
	}
	/**
	 * @return the x-coordinate of the most recently active turtle
	 */
	@Override
	public double doCommand() {
		return myStateRef.getX();
	}
}
