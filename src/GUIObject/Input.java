package GUIObject;


import java.awt.GridLayout;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Input extends GUISection {
   

    public Input (String title, JComponent jc1, JComponent jc2) {
        super(title);
        this.setLayout(new GridLayout(0, 1));
        add(jc1);
        add(jc2);
        setVisible(true);
    }

}
