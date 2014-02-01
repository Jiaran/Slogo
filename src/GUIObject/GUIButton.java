package GUIObject;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import action.GUIAction;


@SuppressWarnings("serial")
public class GUIButton extends JButton {

    public GUIButton (GUIAction action, String text) {
        super();
        this.addActionListener(action);
        this.setText(text);
        this.setToolTipText(text);
        initialBorder();
    }

    private void initialBorder () {
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15),
                                                     this.getBorder()));

    }

}
