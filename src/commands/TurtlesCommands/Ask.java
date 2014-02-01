package commands.TurtlesCommands;

import java.util.ArrayList;
import java.util.List;

import model.FrontToBackParser;
import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand() tells
 * the turtles listed in Arg1 to perform the commands listed in Arg2
 */
public class Ask extends TurtlesCommand {

	public Ask(State state) {
		super(2, state, "Ask");
	}

	/**
	 * tells the turtles listed in Arg1 to perform the commands listed in Arg2
	 * 
	 * @return the result of the last command run
	 */
	@Override
	public double doCommand() {
		List<Integer> formerIDs = new ArrayList<Integer>();
		for (int i : myStateRef.getActiveTurtleIDs()) {
			formerIDs.add(i);
		}

		myStateRef.setActive(getIDList(myArgs.get(0).getStringArg()));
		FrontToBackParser parser = new FrontToBackParser(myStateRef);
		double ret = parser.parseAndRun(myArgs.get(1).getStringArg());
		myStateRef.setActive(formerIDs);

		return ret;
	}
}
