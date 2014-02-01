package model;

/**
 * Stores position values for a state. X and Y are doubles representing distance
 * from the origin, angle is degrees in radians
 */

public class Position {
	private double myX;
	private double myY;
	private double myAngle;

	public Position() {
		myX = 0;
		myY = 0;
		myAngle = 0;
	}
	
	public Position(Position p) {
		myX = p.getX();
		myY = p.getY();
		myAngle = p.getAngle();
	}

	public double setAngle(double setAngle) {
		myAngle = setAngle;
		return setAngle;
	}

	public double setX(double xPos) {
		myX = xPos;
		return xPos;
	}

	public double setY(double yPos) {
		myY = yPos;
		return yPos;
	}

	public double getX() {
		return myX;
	}

	public double getY() {
		return myY;
	}

	public double getAngle() {
		return myAngle;
	}

	public void addDist(double mag) {
		myX += mag * Math.cos(myAngle * 2 * Math.PI / 360);
		myY += mag * Math.sin(myAngle * 2 * Math.PI / 360);
	}
	
	public void addAngle(double angle){
		myAngle += angle;
	}
}
