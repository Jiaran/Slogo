package GUIObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;


public class TurtleDisplay extends DisplayObject {
    private double myAngle = 0;

    private Image myImg = null;
    private boolean isActive = false;
    private boolean myCanHighlight = false;
    private int myWidth = 20;
    private int myHeight = 20;
    private int myMargin = 5;

    public TurtleDisplay (double x, double y, boolean canHighlight, double angle) {
        super(x, y);
        myAngle = angle;
        myCanHighlight = canHighlight;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void draw (Graphics2D g2) {

        AffineTransform tra = new AffineTransform();
        double r = myAngle * 3.1415 / 180;
        tra.rotate(r, (double) myX, (double) myY);

        g2.transform(tra);
        if (myImg == null) {
            int[] x = new int[3];
            x[0] = myX - 5;
            x[1] = myX - 5;
            x[2] = myX + 10;
            int[] y = new int[3];
            y[0] = myY - 8;
            y[1] = myY + 8;
            y[2] = myY;
            Polygon triangle = new Polygon(x, y, 3);

            g2.drawPolygon(triangle);
        }
        else {

            g2.drawImage(myImg, myX - myWidth / 2, myY - myHeight / 2, myWidth, myHeight, null);
        }
        tra.rotate(-2 * r, (double) myX, (double) myY);
        g2.transform(tra);

        if (isActive && myCanHighlight) {
            highlight(g2);
        }
    }

    public void setAngle (double angle) {
        myAngle = angle;
    }

    private void highlight (Graphics2D g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.drawRect(myX - myWidth / 2 - myMargin,
                   myY - myHeight / 2 - myMargin,
                   myWidth + 2 * myMargin,
                   myHeight + 2 * myMargin);
        g.setColor(color);
    }

    public String toString () {
        return "Turtle Info: X:" + myX + " Y:" + myY + " Angle: " + myAngle;
    }

    public void setActive (boolean b) {
        isActive = b;
    }

    public void setImage (Image img) {
        myImg = img;
    }

}
