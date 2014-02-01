package commands.StateCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() sets
 * the shape of the turtle to that represented by an index Arg1
 */
public class SetShape extends StateCommand {

	public SetShape(State state) {
		super(1, state, "SetShape");
	}

	/**
	 * sets the shape of the turtle to that represented by an index Arg1
	 * 
	 * @return the value of Arg1
	 */
	@Override
	public double doCommand() {
		return myStateRef.setImage(myArgs.get(0).getIntArg());
	}
}
