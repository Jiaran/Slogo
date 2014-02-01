package commands.TurtlesCommands;

import java.util.ArrayList;
import java.util.List;

import commands.Command;

import model.Arg;
import model.FrontToBackParser;
import model.State;

/**
 * Use addArg(Arg a) twice to add 2 arguments to this command. doCommand() tells
 * turtles matching the conditions listed in Arg1 to perform the command listed
 * in Arg2
 */
public class AskWith extends TurtlesCommand {

	public AskWith(State state) {
		super(2, state, "AskWith");
	}

	/**
	 * tells turtles matching the conditions listed in Arg1 to perform the
	 * command listed in Arg2
	 * 
	 * @return the result of the last command run
	 */
	@Override
	public double doCommand() {
		List<Integer> formerIDs = new ArrayList<Integer>();
		for (int i : myStateRef.getActiveTurtleIDs()) {
			formerIDs.add(i);
		}

		// tries to evaluate turtle ID with command... hopefully boolean
		String[] condition = myArgs.get(0).getStringArg().split(" ");
		List<Integer> validIDs = new ArrayList<Integer>();
		FrontToBackParser p = new FrontToBackParser(myStateRef);
		
		for (int ID : myStateRef.getTurtles().keySet()) {
			Command c = myStateRef.getCFRef().makeCommand(condition[0]); // Add command
									
			c.addArg(new Arg(ID)); // Add Turtle ID

			for (int i = 1; i < condition.length; i++) { // Add other conditions
				c.addArg(new Arg(p.parseAndRun(condition[i])));
			}

			if (c.canExecute()) { // Check if has enough arguments
				if (c.doCommand() == 1) {
					validIDs.add(ID); // If it evaluates to 1, adds the ID
				}
			} else
				myStateRef
						.setError("Not enough parameters given in AskWith condition"); // Doesn't
																						// have
																						// enough
																						// arguments
		}

		myStateRef.setActive(validIDs);
		FrontToBackParser parser = new FrontToBackParser(myStateRef);
		double ret = parser.parseAndRun(myArgs.get(1).getStringArg());
		myStateRef.setActive(formerIDs);

		return ret;
	}
}
