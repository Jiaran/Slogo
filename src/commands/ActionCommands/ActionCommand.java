package commands.ActionCommands;

import commands.Command;

import model.State;

/**
 * Abstract class for all commands that cause the turtle to do something.
 * (commands that modify state)
 */

public abstract class ActionCommand extends Command {
	public ActionCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}
}
