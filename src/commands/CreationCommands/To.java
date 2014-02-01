package commands.CreationCommands;

import commands.CommandFactory;

import model.State;

/**
 * Use addArg(Arg a) three times to add 3 arguments to this command. doCommand()
 * assigns the commands specified by Arg3 to the command name specified by Arg1
 * using the parameters specified by Arg2
 */
public class To extends CreationCommand {
	CommandFactory myCF;

	public To(State state) {
		super(3, state, "MakeUserInstruction");
		myCF = state.getCFRef();
	}

	/**
	 * Assigns the commands specified by Arg3 to the command name specified by
	 * Arg1 using the parameters specified by Arg2
	 * 
	 * @return 1 if the command is successfully defined, 0 otherwise 
	 */
	@Override
	public double doCommand() {
		myStateRef.addToLibrary("to " + myArgs.get(0).getStringArg() + " [ "
				+ myArgs.get(1).getStringArg() + " ] [ "
				+ myArgs.get(2).getStringArg() + " ]");
		myCF.addUserCommand(myArgs.get(0).getStringArg(), myArgs.get(1)
				.getStringArg(), myArgs.get(2).getStringArg());

		return 1;
	}
}
