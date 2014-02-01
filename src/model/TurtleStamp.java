package model;

public class TurtleStamp {
	private Position myPosition;
	private int myImageID;
	
	public TurtleStamp(Turtle t) {
		myPosition = new Position(t.getPosition());
		myImageID = t.getImageID();
	}
	
	public double readX(){
		return myPosition.getX();
	}
	
	public double readY(){
		return myPosition.getY();
	}
	
	public double readAngle(){
		return myPosition.getAngle();
	}
	
	public int readImageID(){
		return myImageID;
	}
}
