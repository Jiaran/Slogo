package commands;

import model.FrontToBackParser;
import model.State;

public class UserCommand extends Command {
	private String myCommands;
	private String[] myVariables;

	public UserCommand(String[] variables, String caller, String commands,
			State state) {
		super(variables.length, state, "");
		myCallers.add(caller);
		myCommands = commands;
		myVariables = variables;
	}
	
	@Override
	public double doCommand() {
		FrontToBackParser p = new FrontToBackParser(myStateRef);
		
		for(int i = 0; i < myVariables.length; i++){
			myStateRef.getEnvVarRef().addVariable(myVariables[i],
					myArgs.get(i).getDoubleArg());
			}
		return p.parseAndRun(myCommands);
	}
}
