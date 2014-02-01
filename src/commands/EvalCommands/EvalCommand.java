package commands.EvalCommands;

import commands.Command;

import model.State;

/**
 * Default abstract class for all commands that carry out simple evaluations
 */

public abstract class EvalCommand extends Command {
	public EvalCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}
}
