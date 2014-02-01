package GUIObject;

import java.awt.Graphics2D;


abstract public class DisplayObject {
    protected int myX;
    protected int myY;

    public DisplayObject (double x, double y) {
        myX = (int) x;
        myY = (int) y;
    }

    abstract public void draw (Graphics2D g);
}
