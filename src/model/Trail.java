package model;

import java.awt.Color;

public class Trail {

	private double[] firstCoords = new double[2];
	private double[] secondCoords = new double[2];
	private Color myColor;
	private int myThickness;
	
	public Trail(Position one, Position two, Color color, int thickness){
		firstCoords[0] = one.getX();
		firstCoords[1] = one.getY();
		secondCoords[0] = two.getX();
		secondCoords[1] = two.getY();
		myColor = color;
		myThickness = thickness;
	}
	
	public Trail(Trail t) {
		firstCoords = t.readFirstCoords();
		secondCoords = t.readSecondCoords();
		myColor = t.readColor();
		myThickness = t.readThickness();
	}

	public double[] readFirstCoords(){
		return firstCoords;
	}
	
	public double[] readSecondCoords(){
		return secondCoords;
	}
	
	public Color readColor(){
		return myColor;
	}
	
	public int readThickness(){
		return myThickness;
	}
}
