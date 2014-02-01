package commands.InceptionCommands;

import model.FrontToBackParser;
import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * runs the commands given in the list Arg2 and repeats them Arg1 times
 * 
 */
public class Repeat extends InceptionCommand {

	public Repeat(State state) {
		super(2, state, "Repeat");
	}

	/**
	 * Runs the commands given in the list Arg2 and repeats them Arg1 times
	 * 
	 * @return The value of the final command executed
	 */
	@Override
	public double doCommand() {
		FrontToBackParser p = new FrontToBackParser(myStateRef);

		double ret = 0;
		for (int i = 0; i < myArgs.get(0).getIntArg(); i++) {
			myStateRef.getEnvVarRef().addVariable(":repcount", i);
			ret = p.parseAndRun(myArgs.get(1).getStringArg());
		}
		return ret;
	}
}
