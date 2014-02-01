package GUIObject;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Settings extends GUISection {

    private int num = 0;
    

    public Settings (String title) {
        super(title);

        myLayout();
        ;

        this.setMinimumSize(new Dimension(M_WIDTH, M_HEIGHT));
        this.setVisible(true);
    }

    public void addComponent (JComponent b) {
        num++;
        b.setPreferredSize(new Dimension(100, 100));
        add(b);

    }

    @Override
    public Dimension getPreferredSize () {

        return new Dimension(300, (num + 1) / 2 * 60);
    }

    public void myLayout () {
        GridLayout gl = new GridLayout(0, 2);
        gl.setHgap(10);
        gl.setVgap(10);
        this.setLayout(gl);
    }

}
