package commands.InceptionCommands;

import model.FrontToBackParser;
import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * runs the commands specified in Arg1 for each value specified in the range
 * specified by Arg2, i.e., from 0 up to (limit - 1). Note, variable is assigned
 * to each succeeding value so that it can be accessed by the commands returns 1
 * if Arg 1 and Arg 2 are non-zero, 0 otherwise
 */
public class DoTimes extends InceptionCommand {

	public DoTimes(State state) {
		super(2, state, "DoTimes");
	}

	/**
	 * Runs the commands specified in Arg1 for each value specified in the range
	 * specified by Arg2, i.e., from 0 up to (limit - 1). Note, variable is
	 * assigned to each succeeding value so that it can be accessed by the
	 * commands returns 1 if Arg 1 and Arg 2 are non-zero, 0 otherwise
	 * 
	 * @return Depends upon input arguments
	 */
	@Override
	public double doCommand() {
		// not completely sure what DOTIMES is supposed to do...
		// currently parses first argument into a variable name and a limit
		// then runs commands from 0 to limit, with loop value stored in
		// variable
		FrontToBackParser p = new FrontToBackParser(myStateRef);

		String[] subCommandArgs = myArgs.get(0).getStringArg().split(" ");
		String variable = subCommandArgs[0];
		int limit = Integer.parseInt(subCommandArgs[1]);

		double ret = 0;
		for (int i = 0; i < limit; i++) {
			myStateRef.getEnvVarRef().addVariable(variable, i);
			ret = p.parseAndRun(myArgs.get(1).getStringArg());
		}
		return ret;
	}

}
