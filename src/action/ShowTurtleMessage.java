package action;

import javax.swing.JComponent;
import controller.Controller;
import GUIObject.Display;


public class ShowTurtleMessage extends ActionDisplayModify {

    public ShowTurtleMessage (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    protected void modify () {
        ((Display) target).toggleTurtleMessage();

    }

}
