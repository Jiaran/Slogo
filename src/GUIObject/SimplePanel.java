package GUIObject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SimplePanel extends JPanel {
    private DisplayObject myObject;

    public SimplePanel (DisplayObject o) {
        myObject = o;
        this.setPreferredSize(new Dimension(50, 50));
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        myObject.draw(g2);

    }
}
