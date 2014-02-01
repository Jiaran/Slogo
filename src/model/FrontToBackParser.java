package model;

import java.util.Stack;
import commands.Command;
import commands.CommandFactory;

public class FrontToBackParser {
	private EnvironmentVariables myEnvVarRef;
	private Stack<Command> myCommandStack;
	private CommandFactory myCF;
	private State myState;
	private int inceptionLevel;
	private String subCommands;
	private double nextArg;

    public FrontToBackParser (State state) {
        myState = state;
        myEnvVarRef = state.getEnvVarRef();
        myCF = state.getCFRef();
        myCommandStack = new Stack<Command>();
        inceptionLevel = 0;
        nextArg = 0;
    }

	public double parseAndRun(String argument) {
		argument = argument.toLowerCase();
		String[] input = argument.split("\\s");

        for (String s : input) {
            // inception (bracket handling) checking
            if (inceptionLevel > 0) {
                if (s.equals("["))
                    inceptionLevel++;
                else if (s.equals("]")) {
                    inceptionLevel--;
                    if (inceptionLevel == 0)
                        addArg(new Arg(subCommands));
                }
                subCommands += s + " ";
            }
            else {
                if (s.equals("[")) {
                    inceptionLevel++;
                    subCommands = "";
                }

                // matches numbers
                else if (s.matches("-?[0-9]+\\.?[0-9]*")) {
                    addArg(new Arg(Double.parseDouble(s)));
                }

                // matches variables
                else if (s.matches(":[a-zA-z]+")) {
                    if (myCommandStack.peek().isCreation()) {
                        addArg(new Arg(s));
                    }
                    else {
                        addArg(new Arg(s, myEnvVarRef, myState));
                    }
                }

                // matches commands
                else if (s.matches("[a-zA-z_]+(\\?)?")) {
                    if (myCommandStack.empty()
                        || !myCommandStack.peek().isCreation()) {
                        Command c = myCF.makeCommand(s);
                        if (c != null)
                            myCommandStack.push(c);
                        else myState.setError("Unknown command: " + s);
                    }
                    else {
                        addArg(new Arg(s));
                    }
                }
            }
            checkAndRunCommands();
        }
        return nextArg;
    }

    private void addArg (Arg arg) {
        if (!myCommandStack.empty()) {
            myCommandStack.peek().addArg(arg);
        }
        else{
        	nextArg = arg.getDoubleArg();
        }
    }

	public void checkAndRunCommands() {
		while (!myCommandStack.empty() && myCommandStack.peek().canExecute() 
				&& myState.getErrors().size() == 0) {
			nextArg = myCommandStack.pop().doCommand();
			addArg(new Arg(nextArg));
		}
	}
}
