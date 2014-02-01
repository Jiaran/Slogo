package commands.StateCommands;

import model.State;
/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() sets the pen color to a color index value Arg1
 */
public class SetPenColor extends StateCommand {

	public SetPenColor(State state) {
		super(1, state, "SetPenColor");
	}
	/**
	 * sets the pen color to a color index value Arg1
	 * 
	 * @return the value of Arg1
	 */
	@Override
	public double doCommand() {
		return myStateRef.setPenColor(myArgs.get(0).getIntArg());
	}
}
