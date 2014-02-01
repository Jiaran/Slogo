package commands.TurtlesCommands;

import model.State;

/**
 * Use addArg(Arg a) once to add 1 argument to this command. doCommand() sets
 * the turtles listed in Arg1 as the active turtles
 */
public class Tell extends TurtlesCommand {

	public Tell(State state) {
		super(1, state, "Tell");
	}

	/**
	 * sets the turtles listed in Arg1 as the active turtles
	 * 
	 * @return the ID of the last turtle in list Arg1
	 */
	public double doCommand() {
		System.out.println(getIDList(myArgs.get(0).getStringArg()));
		System.out.println("Hello");
		return myStateRef.setActive(getIDList(myArgs.get(0).getStringArg()));
	}
}
