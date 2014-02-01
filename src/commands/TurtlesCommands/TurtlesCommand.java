package commands.TurtlesCommands;

import java.util.ArrayList;
import java.util.List;

import model.State;
import commands.Command;

public abstract class TurtlesCommand extends Command {

	public TurtlesCommand(int argNum, State state, String caller) {
		super(argNum, state, caller);
	}

	public List<Integer> getIDList(String IDs){
		List<Integer> IDList = new ArrayList<Integer>();
		
		String[] stringIDs = IDs.split(" ");
		for(String s : stringIDs){
			IDList.add(Integer.parseInt(s));
		}
		
		return IDList;
	}
}
