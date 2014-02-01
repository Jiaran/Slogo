package action;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import controller.Controller;


public class ActionGetCodeAndRun extends GUIAction {
    String code = "";

    public ActionGetCodeAndRun (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    public void execute () {

        if (target instanceof JTextComponent) {
            code = ((JTextComponent) target).getText();
        }
        else return;
        controller.loadCode(code);
    }

    @Override
    public void undoExecute () {

        controller.undoLoadCode();
    }

    @Override
    public void redoExecute () {

        controller.loadCode(code);
    }
}
