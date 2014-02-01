package GUIObject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;


public class TrailDisplay extends DisplayObject {
    private int myEndX = 0;
    private int myEndY = 0;
    private int myThickness = 1;
    private Color myColor = new Color(0, 0, 0);

    public TrailDisplay (double x, double y, int thickness, Color c) {
        super(x, y);
        myThickness = thickness;
        myColor = c;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void draw (Graphics2D g2d) {
        // Color previous=g.getColor();

        Stroke s = new BasicStroke(myThickness);
        g2d.setStroke(s);
        g2d.setColor(myColor);
        g2d.drawLine(myX, myY, myEndX, myEndY);
        g2d.setStroke(new BasicStroke());
        // g.setColor(previous);

    }

    public void setPosition (double x, double y) {

        myEndX = (int) x;
        myEndY = (int) y;
    }

}
