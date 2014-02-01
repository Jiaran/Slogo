package GUIObject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


@SuppressWarnings("serial")
public class HalfScreen extends JPanel {
    private Component section1;
    private Component section2;

    public HalfScreen (Component jc1, Component jc2) {
        this.setLayout(new BorderLayout());
        section1 = jc1;
        section2 = jc2;
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                                              section1, section2);
      
        splitPane.setPreferredSize(new Dimension(400, 600));
        add(splitPane);
        setVisible(true);
    }

}
