package commands.TurtlesCommands;

import java.util.ArrayList;
import java.util.List;

import model.State;

/**
 * No arguments are needed. doCommand() sets the turtles that have odd IDs as
 * active
 */
public class TellOdd extends TurtlesCommand {

	public TellOdd(State state) {
		super(0, state, "TellOdd");
	}

	/**
	 * sets the turtles that have odd IDs as active
	 * 
	 * @return the last turtle's ID value
	 */
	@Override
	public double doCommand() {
		List<Integer> oddTurtles = new ArrayList<Integer>();
		for (int ID : myStateRef.getTurtles().keySet()) {
			if (ID % 2 == 1) {
				oddTurtles.add(ID);
			}
		}
		return myStateRef.setActive(oddTurtles);
	}
}
