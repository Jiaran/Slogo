package commands.ActionCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() changes
 * the heading of the turtle by rotating it counter-clockwise an angle equal to
 * Arg1
 */
public class Left extends ActionCommand {

	public Left(State state) {
		super(1, state, "Left");
	}

	/**
	 * Changes the heading of the turtle by rotating it counter-clockwise an
	 * angle equal to Arg1
	 * 
	 * @return the double value of Arg 1
	 */
	public double doCommand() {
		double setAngle = myArgs.get(0).getDoubleArg();

		myStateRef.addAngle(setAngle * -1);
		myStateRef.setNotification("Turtle has turned to the left " + setAngle
				+ " degrees");
		return setAngle;
	}
}