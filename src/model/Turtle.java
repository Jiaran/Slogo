package model;

import java.util.ArrayList;
import java.util.List;

public class Turtle {
	private State myStateRef;

	// Position
	private Position myPosition;

	// Trails
	private List<Trail> myTrails;
	private boolean penIsDown;

	// Visibility
	private boolean isVisible;
	private int myImageID;

	public Turtle(State state) {
		myPosition = new Position();
		myTrails = new ArrayList<Trail>();
		isVisible = true;
		penIsDown = true;
		myStateRef = state;
		myImageID = -1;
	}

	public Turtle(Turtle turtle, State state) {
		myPosition = new Position(turtle.getPosition());
		myTrails = copyListTrails(turtle.getTrails());
		isVisible = turtle.getVisibility();
		penIsDown = turtle.getPenIsDown();
		myStateRef = state;
		myImageID = turtle.getImageID();
	}

	private List<Trail> copyListTrails(List<Trail> trails) {
		List<Trail> ret = new ArrayList<Trail>();
		for(Trail t: trails){
			ret.add(new Trail(t));
		}
		return ret;
	}

	public void addTrail(Position a, Position b) {
		Trail t = new Trail(a, b, myStateRef.getLineColor(),
				myStateRef.getLineThickness());

		if (penIsDown) {
			myTrails.add(t);
		}
	}

	public void clearTrails() {
		myTrails.clear();
	}

	public void setPenIsDown(boolean isPenDown) {
		penIsDown = isPenDown;
	}

	public void setVisibility(boolean setVisible) {
		isVisible = setVisible;
	}
	
	public void setImageIndex(int ID) {
		myImageID = ID;
	}

	public boolean getPenIsDown() {
		return penIsDown;
	}

	public boolean getVisibility() {
		return isVisible;
	}
	
	public int getImageID() {
		return myImageID;
	}

	public Position getPosition() {
		return myPosition;
	}

	public List<Trail> getTrails() {
		return myTrails;
	}

	public double addAngle(double angle) {
		Position init = new Position(myPosition);
		myPosition.addAngle(angle);
		Position end = new Position(myPosition);
		addTrail(init, end);

		return angle;
	}

	public void moveForward(double dist) {
		Position init = new Position(myPosition);
		myPosition.addDist(dist);
		Position end = new Position(myPosition);
		addTrail(init, end);
	}

	public double resetPosition() {
		Position init = new Position(myPosition);
		myPosition = new Position();
		Position end = new Position(myPosition);
		addTrail(init, end);
		return Math.sqrt(Math.pow(init.getX() - end.getX(), 2)
				+ Math.pow(init.getY() - end.getY(), 2));
	}

	public double setXY(double X, double Y) {
		Position init = new Position(myPosition);
		myPosition.setX(X);
		myPosition.setY(Y);
		Position end = new Position(myPosition);
		addTrail(init, end);

		return calcDistance(init, end);
	}

	private double calcDistance(Position init, Position end) {
		return Math.sqrt(Math.pow(init.getX() - end.getX(), 2)
				+ Math.pow(init.getY() - end.getY(), 2));
	}
}
