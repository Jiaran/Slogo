package commands.ActionCommands;

import model.State;
/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() changes
 * the heading of the turtle to an angle specified by Arg1
 */
public class SetHeading extends ActionCommand {

	public SetHeading(State state) {
		super(1, state, "SetHeading");
	}
	/**
	 * Changes the heading of the turtle to an angle specified by Arg1
	 * 
	 * @return the number of degrees turned
	 */
	public double doCommand() {
		myStateRef.setNotification("Turtle is now facing " + myArgs.get(0).getDoubleArg()
				+ " degrees");
		return myStateRef.turnTowards(myArgs.get(0).getDoubleArg());
	}
}
