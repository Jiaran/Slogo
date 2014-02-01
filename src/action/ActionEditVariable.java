package action;

import javax.swing.JComponent;
import controller.Controller;


public class ActionEditVariable extends ActionInputArgAndRunCommands {

    public ActionEditVariable (JComponent target, Controller c) {
        super(target, c);
        inputDialogText = "Input a new value for this variable";
        inputDialogTitle = "Edit Variable";
    }

    @Override
    protected String generateCode (String name, String args) {
        return "set " + name + " " + args;
    }

}
