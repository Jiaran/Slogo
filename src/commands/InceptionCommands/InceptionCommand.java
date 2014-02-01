package commands.InceptionCommands;

import model.State;
import commands.Command;

public abstract class InceptionCommand extends Command {
	public InceptionCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}
}
