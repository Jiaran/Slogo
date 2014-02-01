package action;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import controller.Controller;


public class ModifyPenColor extends ActionDisplayModify {

    public ModifyPenColor (JComponent target, Controller c) {
        super(target, c);
        
    }

    @Override
    protected void modify () {
        Color color = JColorChooser.showDialog(null, "choose a color", Color.black);
        if (color == null)
            return;
        controller.changePenColor(color);
    }

    @Override
    public void undoExecute () {

        controller.undoLoadCode();
    }

    @Override
    public void redoExecute () {

        controller.undoLoadCode();
    }
}
