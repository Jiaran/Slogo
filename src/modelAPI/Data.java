package modelAPI;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.State;
import model.Trail;
import model.Turtle;
import model.TurtleStamp;

public class Data {
	private Map<String, Double> curVariables;
	private Map<String, Integer> curCommands;
	private List<String> curErrors;
	private List<String> curNotifications;
	private List<String> curHistory;
	private List<String> curLibrary;
	private Map<Integer, Turtle> curTurtles;
	private List<Integer> curActiveTurtlesIDs;
	private Color curBGColor;
	private List<TurtleStamp> curStamps;
	private List<Color> curColors;
	
    public Data(State state){
    	curVariables = state.getEnvVarRef().getVariables();
    	curCommands = state.getCFRef().getUserCommandMap();
    	curErrors = state.getErrors();
    	curNotifications = state.getNotifications();
    	curHistory = state.getHistory();
    	curLibrary = state.getLibrary();
    	curTurtles = state.getTurtles();
    	curActiveTurtlesIDs = state.getActiveTurtleIDs();
    	curBGColor = state.getBGColor();
    	curStamps = state.getTurtleStamps();
    	curColors = state.getColors();
    }
    
    public List<Integer> readActiveTurtleIDs(){
    	return curActiveTurtlesIDs;
    }
    
    public List<Integer> readTurtleIDs(){
    	List<Integer> turtleIDs = new ArrayList<Integer>();
    	turtleIDs.addAll(curTurtles.keySet());
    	
    	return turtleIDs;
    }
    
    public List<TurtleStamp> readStamps(){
    	return curStamps;
    }
    
    public Color readBGColor(){
    	return curBGColor;
    }
    
    public List<String> readVariables(){
    	List<String> variables = new ArrayList<String>();
    	for(String key: curVariables.keySet()){
    		String s = key + " " + curVariables.get(key).toString();
    		variables.add(s);
    	}
    	
    	return variables;
    }
    
    public List<String> readCommands(){
    	List<String> commands = new ArrayList<String>();
    	for(String key: curCommands.keySet()){
    		String s = key;
    		for(int i = 0; i < curCommands.get(key); i++){
    			s += " arg" + i;
    		}
    		commands.add(s);
    	}
    	return commands;
    }
    
    public boolean readTurtleVisibility(int turtleID){
    	return curTurtles.get(turtleID).getVisibility();
    }
    
    public double readTurtleX(int turtleID){
    	return curTurtles.get(turtleID).getPosition().getX();
    }
    
    public double readTurtleY(int turtleID){
    	return curTurtles.get(turtleID).getPosition().getY();
    }
    
    public double readTurtleAngle(int turtleID){
    	return curTurtles.get(turtleID).getPosition().getAngle();
    }
    
    public List<Trail> readTrails(int turtleID){
    	return curTurtles.get(turtleID).getTrails();
    }    
    
    public int readImageID(int turtleID){
    	return curTurtles.get(turtleID).getImageID();
    }
    
    public String readErrors(){
    	if(curErrors.size() == 0)
    		return "";
    	return curErrors.get(0);
    }
    
    public List<String> readNotifications(){
    	return curNotifications;
    }
    
    public List<String> readHistory(){
    	return curHistory;
    }
    
    public List<String> readLibrary(){
    	return curLibrary;
    }
    
    public List<Color> readColors() {
    	return curColors;
    }
}
