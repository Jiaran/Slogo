package commands.StateCommands;

import model.State;
/**
 * Use addArg(Arg a) once to add 1 arguments to this command. doCommand()
 * sets the size of the pen to Arg1 pixels
 */
public class SetPenSize extends StateCommand {

	public SetPenSize(State state) {
		super(1, state, "SetPenSize");
	}
	/**
	 * sets the size of the pen to Arg1 pixels
	 * 
	 * @return the value of Arg1
	 */
	@Override
	public double doCommand() {
		return myStateRef.setPenThickness(myArgs.get(0).getIntArg());
	}
}
