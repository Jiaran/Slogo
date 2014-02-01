package commands.InceptionCommands;

import model.FrontToBackParser;
import model.State;
/**
 * Use addArg(Arg a) twice to add two arguments to this command. If Arg1 is not
 * 0, doCommand() runs the commands given in the list Arg2 and returns the value
 * of the final command executed
 */
public class If extends InceptionCommand {

	public If(State state) {
		super(2, state, "If");
	}
	/**
	 * If Arg1 is not 0, runs the commands given in the list Arg2
	 * and returns the value of the final command executed
	 * 
	 * @return The value of the final command executed
	 */
	@Override
	public double doCommand() {
		FrontToBackParser p = new FrontToBackParser(myStateRef);

		if (p.parseAndRun(myArgs.get(0).getStringArg()) != 0) {
			return p.parseAndRun(myArgs.get(1).getStringArg());
		}
		return 0;
	}
}
