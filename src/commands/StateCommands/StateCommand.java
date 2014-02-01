package commands.StateCommands;

import model.State;
import commands.Command;

public abstract class StateCommand extends Command {
	public StateCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}
}
