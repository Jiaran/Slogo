package commands.BooleanCommands;

import model.State;
import commands.Command;

public abstract class BooleanCommand extends Command {
	public BooleanCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}
}
