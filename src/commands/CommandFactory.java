package commands;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.CreationCommands.Set;
import commands.CreationCommands.To;
import commands.EvalCommands.*;
import commands.InceptionCommands.*;
import commands.ActionCommands.*;
import commands.BooleanCommands.*;
import commands.QueryCommands.*;
import commands.StateCommands.*;
import commands.TurtlesCommands.*;

import model.State;

public class CommandFactory {
	private List<Command> masterCommandList;
	private State myStateRef;

	public CommandFactory(State state) {
		myStateRef = state;
		refreshCommands(state);
	}

	public void refreshCommands(State state) {
		masterCommandList = new ArrayList<Command>();
		// ActionCommands
		masterCommandList.add(new Back(state));
		masterCommandList.add(new ClearScreen(state));
		masterCommandList.add(new Forward(state));
		masterCommandList.add(new HideTurtle(state));
		masterCommandList.add(new Home(state));
		masterCommandList.add(new Left(state));
		masterCommandList.add(new Right(state));
		masterCommandList.add(new SetHeading(state));
		masterCommandList.add(new SetXY(state));
		masterCommandList.add(new ShowTurtle(state));
		masterCommandList.add(new Towards(state));

		// BooleanCommands
		masterCommandList.add(new And(state));
		masterCommandList.add(new Equal(state));
		masterCommandList.add(new Greater(state));
		masterCommandList.add(new Less(state));
		masterCommandList.add(new Not(state));
		masterCommandList.add(new NotEqual(state));
		masterCommandList.add(new Or(state));

		// CreationCommands
		masterCommandList.add(new Set(state));
		masterCommandList.add(new To(state));

		// EvalCommands
		masterCommandList.add(new ATan(state));
		masterCommandList.add(new Cos(state));
		masterCommandList.add(new Difference(state));
		masterCommandList.add(new Log(state));
		masterCommandList.add(new Minus(state));
		masterCommandList.add(new Pow(state));
		masterCommandList.add(new Product(state));
		masterCommandList.add(new Quotient(state));
		masterCommandList.add(new Random(state));
		masterCommandList.add(new Remainder(state));
		masterCommandList.add(new Sin(state));
		masterCommandList.add(new Sum(state));
		masterCommandList.add(new Tan(state));

		// InceptionCommands
		masterCommandList.add(new DoTimes(state));
		masterCommandList.add(new For(state));
		masterCommandList.add(new If(state));
		masterCommandList.add(new Ifelse(state));
		masterCommandList.add(new Repeat(state));

		// QueryCommands
		masterCommandList.add(new Heading(state));
		masterCommandList.add(new ID(state));
		masterCommandList.add(new PenColor(state));
		masterCommandList.add(new PenDownP(state));
		masterCommandList.add(new ShowingP(state));
		masterCommandList.add(new Shape(state));
		masterCommandList.add(new ShowingP(state));
		masterCommandList.add(new XCor(state));
		masterCommandList.add(new YCor(state));

		// StateCommands
		masterCommandList.add(new ClearStamps(state));
		masterCommandList.add(new PenDown(state));
		masterCommandList.add(new PenUp(state));
		masterCommandList.add(new SetBackground(state));
		masterCommandList.add(new SetPalette(state));
		masterCommandList.add(new SetPenColor(state));
		masterCommandList.add(new SetPenSize(state));
		masterCommandList.add(new SetShape(state));
		masterCommandList.add(new Stamp(state));

		// TurtlesCommands
		masterCommandList.add(new Ask(state));
		masterCommandList.add(new AskWith(state));
		masterCommandList.add(new Tell(state));
		masterCommandList.add(new TellEven(state));
		masterCommandList.add(new TellOdd(state));
	}

	public Command makeCommand(String s) {
		for (Command c : masterCommandList) {
			for (String caller : c.getCallers()) {
				if (caller.equals(s)) {
					try {
						return (Command) c.getClass().getConstructors()[0]
								.newInstance(myStateRef);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
					return c;
				}
			}
		}

		for (Command c : myStateRef.getUserCommandList()) {
			for (String caller : c.getCallers()) {
				if (caller.equals(s)) {
					try {
						return (Command) c.getClass().getConstructors()[0]
								.newInstance(myStateRef.getUserVariables().get(s), s,
										myStateRef.getUserCommandCommands().get(s), myStateRef);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
					return c;
				}
			}
		}
		return null;
	}

	public void addUserCommand(String caller, String string, String commands) {
		String[] variables = string.split(" ");

		if (variables[0].equals("")) {
			variables = new String[0];
		}
		myStateRef.setUserVariable(caller, variables);
		myStateRef.setUserCommandCommands(caller, commands);
		myStateRef.setUserCommand(new UserCommand(variables, caller, commands,
				myStateRef));
	}

	public Map<String, Integer> getUserCommandMap() {
		Map<String, Integer> commandMap = new HashMap<String, Integer>();
		for (Command c : myStateRef.getUserCommandList()) {
			commandMap.put(c.getCallers().get(0), c.getArgNum());
		}
		return commandMap;
	}
}
