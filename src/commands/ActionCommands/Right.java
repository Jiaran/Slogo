package commands.ActionCommands;

import model.State;
/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() changes
 * the heading of the turtle by rotating it clockwise an angle equal to Arg1
 */
public class Right extends ActionCommand {

	public Right(State state) {
		super(1, state, "Right");
	}
	/**
	 * Changes the heading of the turtle by rotating it clockwise an angle equal to Arg1
	 * 
	 * @return the double value of Arg 1
	 */
	public double doCommand() {
		double setAngle = myArgs.get(0).getDoubleArg();

		myStateRef.addAngle(setAngle);
		myStateRef.setNotification("Turtle has turned to the right " + setAngle
				+ " degrees");
		return setAngle;
	}
}
