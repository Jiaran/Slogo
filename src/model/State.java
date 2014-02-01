package model;

import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import commands.Command;
import commands.CommandFactory;

/**
 * Deals with general state of the model
 */

public class State {
	// Model
	private EnvironmentVariables myEnvVarRef;
	private CommandFactory myCFRef;
	private List<Color> myColors;

	// Turtles
	private Map<Integer, Turtle> myTurtles;
	private List<Integer> myActiveTurtleIDs;
	private int lastActiveTurtleID;

	// Feedback
	private List<String> myNotifications;
	private List<String> myErrors;
	private List<String> myHistory;

	// Trails
	private int lineColor;
	private int lineThickness;
	private List<TurtleStamp> myStamps;

	// Visual
	private Color myBGColor;

	// User Library
	private List<String> myLibrary;

	private List<Command> userCommandList; // should have wrapped these into an object...
	private Map<String, String[]> userVariables;
	private Map<String, String> userCommandCommands;
	
	// Language
	private ResourceBundle myRB;

	public State(EnvironmentVariables envVars) {
		setRB(Locale.ENGLISH);
		myErrors = new ArrayList<String>();
		myNotifications = new ArrayList<String>();
		myHistory = new ArrayList<String>();
		myTurtles = new HashMap<Integer, Turtle>();
		myActiveTurtleIDs = new ArrayList<Integer>();
		myEnvVarRef = envVars;
		myLibrary = new ArrayList<String>();
		myCFRef = new CommandFactory(this);
		lineColor = 0;
		lineThickness = 0;
		myStamps = new ArrayList<TurtleStamp>();
		userCommandList = new ArrayList<Command>();
		userVariables = new HashMap<String, String[]>();
		userCommandCommands = new HashMap<String, String>();
		initColors();
	}

	public State(State state) {
		setRB(Locale.ENGLISH);
		myErrors = copyListS(state.myErrors);
		myNotifications = copyListS(state.myNotifications);
		myHistory = copyListS(state.myHistory);
		myTurtles = copyMap(state.myTurtles);
		myActiveTurtleIDs = copyListI(state.myActiveTurtleIDs);
		myEnvVarRef = new EnvironmentVariables(state.myEnvVarRef.getVariables());
		myLibrary = copyListS(state.getLibrary());
		myCFRef = new CommandFactory(this);
		lineColor = state.getLineIndex();
		lineThickness = state.getLineThickness();
		myStamps = copyListStamp(state.getTurtleStamps());
		userCommandList = state.getUserCommandList(); // need to do a deep copy to do get rid of usercommands on undo.
		userVariables = state.getUserVariables();
		userCommandCommands = state.getUserCommandCommands();
		initColors();
	}
	
	private List<String> copyListS(List<String> list) {
		List<String> ret = new ArrayList<String>();
		for (String s : list) {
			ret.add(s);
		}
		return ret;
	}

	private Map<Integer, Turtle> copyMap(Map<Integer, Turtle> map) {
		Map<Integer, Turtle> ret = new HashMap<Integer, Turtle>();
		for (int i : map.keySet()) {
			ret.put(i, new Turtle(map.get(i), this));
		}
		return ret;
	}

	private List<Integer> copyListI(List<Integer> list) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i : list) {
			ret.add(i);
		}
		return ret;
	}

	private List<TurtleStamp> copyListStamp(List<TurtleStamp> list) {
		List<TurtleStamp> ret = new ArrayList<TurtleStamp>();
		for (TurtleStamp ts : list) {
			ret.add(ts);
		}
		return ret;
	}

	private void initColors() {
		myColors = new ArrayList<Color>();
		myColors.add(Color.BLACK);
		myColors.add(Color.BLACK);
		myColors.add(Color.RED);
		myColors.add(Color.ORANGE);
		myColors.add(Color.YELLOW);
		myColors.add(Color.GREEN);
		myColors.add(Color.BLUE);
		myColors.add(Color.GRAY);
		myColors.add(Color.WHITE);
	}

	public void setLocale(Locale l) {
		setRB(l);
		myCFRef.refreshCommands(this);
	}

	public void setRB(Locale l) {
		File file = new File("language/");
		ClassLoader loader = null;

		try {
			URL[] urls = { file.toURI().toURL() };
			loader = new URLClassLoader(urls);
		} catch (MalformedURLException ex) {
		}

		myRB = ResourceBundle.getBundle("command", l, loader);
	}

	public void addTurtle(int ID) {
		Turtle t = new Turtle(this);
		myTurtles.put(ID, t);
		myActiveTurtleIDs.add(ID);
		lastActiveTurtleID = ID;
	}

	public int setActive(List<Integer> turtleIDs) {
		if (!turtleIDs.isEmpty()) { // doesn't make sense if there are no IDs
			for (int i : turtleIDs) {
				if (!myTurtles.containsKey(i))
					addTurtle(i);
			}
			lastActiveTurtleID = turtleIDs.get(turtleIDs.size() - 1);
			myActiveTurtleIDs = turtleIDs;
			return lastActiveTurtleID;
		}
		setError("No active turtles");
		myActiveTurtleIDs.clear();
		return 0;
	}

	public void addStamps() {
		for (int i : myActiveTurtleIDs) {
			myStamps.add(new TurtleStamp(myTurtles.get(i)));
		}
	}

	public void clearStamps() {
		myStamps.clear();
	}

	public void setError(String error) {
		myErrors.add("ERROR: " + error);
		System.out.println("ERROR: " + error);
	}

	public void setNotification(String notification) {
		myNotifications.add(notification);
		System.out.println(notification);
	}

	public void addToLibrary(String function) {
		myLibrary.add(function);
	}

	public void addHistory(String code) {
		myHistory.add(code);
	}

	public double addColor(int index, Color color) {
		myColors.add(index, color);
		return index;
	}

	public double setPenColor(int index) {
		if (index >= myColors.size()) {
			setError("Unknown Color index");
		}
		lineColor = index;
		return index;
	}

	public double setBGColor(int index) {
		if (index >= myColors.size()) {
			setError("Unknown Color index");
		}
		myBGColor = myColors.get(index);
		return index;
	}

	public double setPenThickness(int t) {
		lineThickness = t;
		return t;
	}

	public Map<Integer, Turtle> getTurtles() {
		return myTurtles;
	}

	public List<String> getErrors() {
		return myErrors;
	}

	public List<String> getNotifications() {
		return myNotifications;
	}

	public List<String> getHistory() {
		return myHistory;
	}

	public List<String> getLibrary() {
		return myLibrary;
	}

	public List<TurtleStamp> getTurtleStamps() {
		return myStamps;
	}

	public EnvironmentVariables getEnvVarRef() {
		return myEnvVarRef;
	}

	public ResourceBundle getRB() {
		return myRB;
	}

	public CommandFactory getCFRef() {
		return myCFRef;
	}

	public Color getLineColor() {
		return myColors.get(lineColor);
	}
	
	public int getLineIndex(){
		return lineColor;
	}

	public Color getBGColor() {
		return myBGColor;
	}

	public int getLineThickness() {
		return lineThickness;
	}

	public int getColorIndex() {
		return myColors.indexOf(lineColor);
	}

	public int getShapeIndex() {
		return myTurtles.get(lastActiveTurtleID).getImageID();
	}

	public void setPenIsDown(boolean isPenDown) {
		for (int i : myActiveTurtleIDs) {
			myTurtles.get(i).setPenIsDown(isPenDown);
		}
	}

	public void setVisibility(boolean setVisible) {
		for (int i : myActiveTurtleIDs) {
			myTurtles.get(i).setVisibility(setVisible);
		}
	}

	public double setImage(int index) {
		for (int i : myActiveTurtleIDs) {
			myTurtles.get(i).setImageIndex(index);
		}
		return index;
	}

	public double moveForward(double dist) {
		for (int i : myActiveTurtleIDs) {
			myTurtles.get(i).moveForward(dist);
		}
		return dist;
	}

	public void clearTrails() {
		for (int i : myActiveTurtleIDs) {
			myTurtles.get(i).clearTrails();
		}
	}

	public double addAngle(double angle) {
		for (int i : myActiveTurtleIDs) {
			myTurtles.get(i).addAngle(angle);
		}
		return angle;
	}

	public double resetPosition() {
		double distance = 0;

		for (int i : myActiveTurtleIDs) {
			distance = myTurtles.get(i).resetPosition();
		}

		return distance;
	}

	public double setXY(double X, double Y) {
		double distance = 0;

		for (int i : myActiveTurtleIDs) {
			distance = myTurtles.get(i).setXY(X, Y);
		}
		return distance;
	}

	public double turnTowards(double angle) {
		double turnAngle = 0;

		for (int i : myActiveTurtleIDs) {
			turnAngle = myTurtles.get(i).addAngle(
					angle - myTurtles.get(i).getPosition().getAngle());
		}
		return turnAngle;
	}

	public double turnTowards(double X, double Y) {
		double distance = 0;

		for (int i : myActiveTurtleIDs) {
			Position init = myTurtles.get(i).getPosition();

			double startingAngle = init.getAngle();
			double finalAngle = 360
					* Math.atan((Y - init.getY()) / (X - init.getX())) / 2
					/ Math.PI;

			distance = myTurtles.get(i).addAngle(startingAngle - finalAngle);
		}
		return distance;
	}

	public double getLastActiveTurtleID() {
		return lastActiveTurtleID;
	}

	public double getAngle() {
		return myTurtles.get(lastActiveTurtleID).getPosition().getAngle();
	}

	public double getX() {
		return myTurtles.get(lastActiveTurtleID).getPosition().getX();
	}

	public double getY() {
		return myTurtles.get(lastActiveTurtleID).getPosition().getY();
	}

	public boolean getPenIsDown() {
		return myTurtles.get(lastActiveTurtleID).getPenIsDown();
	}

	public boolean getVisibility() {
		return myTurtles.get(lastActiveTurtleID).getVisibility();
	}

	public List<Color> getColors() {
		return myColors;
	}

	public List<Integer> getActiveTurtleIDs() {
		return myActiveTurtleIDs;
	}

	public void clearErrors() {
		myErrors.clear();
	}

	public List<Command> getUserCommandList() {
		return userCommandList;
	}

	public void setUserCommand(Command userCommand) {
		userCommandList.add(userCommand);
	}

	public Map<String, String[]> getUserVariables() {
		return userVariables;
	}

	public void setUserVariable(String key, String[] variables) {
		userVariables.put(key, variables);
	}

	public Map<String, String> getUserCommandCommands() {
		return userCommandCommands;
	}

	public void setUserCommandCommands(String key, String commands) {
		userCommandCommands.put(key, commands);
	}
}
