package commands.InceptionCommands;

import model.FrontToBackParser;
import model.State;

/**
 * Use addArg(Arg a) three times to add three arguments to this command. If Arg1
 * is not 0, doCommand() runs the trueCommands given in Arg2, otherwise runs the
 * falseCommands given in Arg3 and returns the value of the final command
 * executed
 */
public class Ifelse extends InceptionCommand {

	public Ifelse(State state) {
		super(3, state, "IfElse");
	}

	/**
	 * If Arg1 is not 0, runs the trueCommands given in Arg2,
	 * otherwise runs the falseCommands given in Arg3 and returns the value of
	 * the final command executed
	 * 
	 * @return Depends upon input arguments
	 */
	@Override
	public double doCommand() {
		FrontToBackParser p = new FrontToBackParser(myStateRef);

		if (p.parseAndRun(myArgs.get(0).getStringArg()) != 0) {
			return p.parseAndRun(myArgs.get(1).getStringArg());
		} else {
			return p.parseAndRun(myArgs.get(2).getStringArg());
		}
	}
}
