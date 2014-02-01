package commands.QueryCommands;

import commands.Command;

import model.State;

public abstract class QueryCommand extends Command {
	public QueryCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}
}
