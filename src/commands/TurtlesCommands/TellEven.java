package commands.TurtlesCommands;

import java.util.ArrayList;
import java.util.List;

import model.State;

/**
 * No arguments are needed. doCommand() sets the turtles that have even IDs as
 * active
 */
public class TellEven extends TurtlesCommand {

	public TellEven(State state) {
		super(0, state, "TellEven");
	}

	/**
	 * sets the turtles that have even IDs as active
	 * 
	 * @return the last turtle's ID value
	 */
	@Override
	public double doCommand() {
		List<Integer> evenTurtles = new ArrayList<Integer>();
		for (int ID : myStateRef.getTurtles().keySet()) {
			if (ID % 2 == 0) {
				evenTurtles.add(ID);
			}
		}
		return myStateRef.setActive(evenTurtles);
	}
}
