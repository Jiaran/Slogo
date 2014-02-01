package commands.InceptionCommands;

import model.FrontToBackParser;
import model.State;

/**
 * Use addArg(Arg a) twice to add two arguments to this command. doCommand()
 * runs the commands in Arg2 for each value specified in the range of Arg1,
 * i.e., from start up to end, going by increment. note, variable is assigned to
 * each succeeding value so that it can be accessed by the commands
 */
public class For extends InceptionCommand {

	public For(State state) {
		super(2, state, "For");
	}

	/**
	 * Runs the commands in Arg2 for each value specified in the range of Arg1,
	 * i.e., from start up to end, going by increment. note, variable is
	 * assigned to each succeeding value so that it can be accessed by the
	 * commands
	 * 
	 * @return return value from last command run
	 */
	@Override
	public double doCommand() {
		FrontToBackParser p = new FrontToBackParser(myStateRef);

		String[] subCommandArgs = myArgs.get(0).getStringArg().split(" ");
		String variable = subCommandArgs[0];
		int start = Integer.parseInt(subCommandArgs[1]);
		int end = Integer.parseInt(subCommandArgs[2]);
		int increment = Integer.parseInt(subCommandArgs[3]);

		double ret = 0;
		for (int i = start; i <= end; i += increment) {
			myStateRef.getEnvVarRef().addVariable(variable, i);
			ret = p.parseAndRun(myArgs.get(1).getStringArg());
		}

		return ret;
	}

}
