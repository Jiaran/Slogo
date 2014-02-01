package commands.CreationCommands;

import model.State;
import commands.Command;

public abstract class CreationCommand extends Command {
	
	public CreationCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
		isCreation = true;
	}
}
