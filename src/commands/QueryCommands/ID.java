package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns the ID of the most recently active turtle
 */
public class ID extends QueryCommand {

	public ID(State state) {
		super(0, state, "ID");
	}
	/**
	 * @return the ID of the most recently active turtle
	 */
	@Override
	public double doCommand() {
		return myStateRef.getLastActiveTurtleID();
	}
}
