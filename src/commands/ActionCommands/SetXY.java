package commands.ActionCommands;

import model.State;

/**
 * Use addArg(Arg a) twice to add 2 argument to this command. doCommand() sets
 * the (x, y) position of the turtle to (Arg1, Arg2)
 */
public class SetXY extends ActionCommand {

	public SetXY(State state) {
		super(2, state, "SetPosition");
	}

	/**
	 * Sets the (x, y) position of the turtle to (Arg1, Arg2)
	 * 
	 * @return the distance moved
	 */
	public double doCommand() {
		double movementMag = myStateRef.setXY(myArgs.get(0).getDoubleArg(),
				myArgs.get(1).getDoubleArg());
		myStateRef.setNotification("Turtle's position has been set to ("
				+ myArgs.get(0).getDoubleArg() + ", "
				+ myArgs.get(1).getDoubleArg() + ")");

		return movementMag;
	}
}