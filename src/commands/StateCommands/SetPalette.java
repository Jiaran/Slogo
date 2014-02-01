package commands.StateCommands;

import java.awt.Color;

import model.State;

/**
 * Use addArg(Arg a) 4 times to add 4 arguments to this command. doCommand()
 * sets color corresponding at given color_index Arg1 to given r g b color
 * values Arg2, Arg3, and Arg 4
 */
public class SetPalette extends StateCommand {

	public SetPalette(State state) {
		super(4, state, "SetPalette");
	}

	/**
	 * sets color corresponding at given color_index Arg1 to given r g b color
	 * values Arg2, Arg3, and Arg 4
	 * 
	 * @return the value of Arg1
	 */
	@Override
	public double doCommand() {
		Color c = new Color(myArgs.get(1).getIntArg(), myArgs.get(2)
				.getIntArg(), myArgs.get(3).getIntArg());
		return myStateRef.addColor(myArgs.get(0).getIntArg(), c);
	}
}
