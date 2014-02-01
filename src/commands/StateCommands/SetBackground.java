package commands.StateCommands;

import model.State;
/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() sets the background color to a given color index Arg1
 */
public class SetBackground extends StateCommand {

	public SetBackground(State state) {
		super(1, state, "SetBackground");
	}
	/**
	 * sets the background color to a given color index Arg1
	 * 
	 * @return the value of Arg1
	 */
	@Override
	public double doCommand() {
		return myStateRef.setBGColor(myArgs.get(0).getIntArg());
	}
}
