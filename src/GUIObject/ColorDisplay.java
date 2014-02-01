package GUIObject;

import java.awt.Color;
import java.awt.Graphics2D;


public class ColorDisplay extends DisplayObject {
    private Color myColor;

    public ColorDisplay (Color c) {
        super(0, 0);
        myColor = c;
    }

    @Override
    public void draw (Graphics2D g) {

        g.setColor(myColor);

        g.fillRect(0, 0, 50, 50);

    }

}
