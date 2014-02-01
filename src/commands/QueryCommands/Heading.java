package commands.QueryCommands;

import model.State;
/**
 * No arguments are needed. doCommand() returns the heading of the most recently active turtle
 */
public class Heading extends QueryCommand {

	public Heading(State state) {
		super(0, state, "Heading");
	}
	/**
	 * @return the heading of the most recently active turtle
	 */
	@Override
	public double doCommand() {
		return myStateRef.getAngle();
	}
}
