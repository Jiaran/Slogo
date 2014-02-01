package action;

import javax.swing.JComponent;
import controller.Controller;
import GUIObject.Display;


public class ModifyGrid extends ActionDisplayModify {

    public ModifyGrid (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    protected void modify () {

        ((Display) target).toggleGrid();

    }

}
