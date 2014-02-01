package GUIObject;

import java.awt.Graphics2D;
import java.awt.Image;


public class ImageDisplay extends DisplayObject {
    private Image myImage;

    public ImageDisplay (Image img) {
        super(0, 0);
        myImage = img;

    }

    @Override
    public void draw (Graphics2D g) {
        if (myImage == null)
            return;
        g.drawImage(myImage, 0, 0, 50, 50, null);

    }

}
