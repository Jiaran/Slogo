package action;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import controller.Controller;


public class ModifyBGColor extends ActionDisplayModify {
    Color color = null;

    public ModifyBGColor (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    protected void modify () {
        color = JColorChooser.showDialog(null, "choose a color", Color.black);
        color = controller.changeBGColor(color);
    }

    @Override
    public void undoExecute () {

        color = controller.changeBGColor(color);
    }

    @Override
    public void redoExecute () {

        color = controller.changeBGColor(color);
    }
}
