package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns the turtle's current shape index
 */
public class Shape extends QueryCommand {

	public Shape(State state) {
		super(0, state, "GetShape");
	}
	/**
	 * @return the turtle's current shape index
	 */
	@Override
	public double doCommand() {
		return myStateRef.getShapeIndex();
	}
}
