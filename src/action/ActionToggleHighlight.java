package action;

import javax.swing.JComponent;
import controller.Controller;


public class ActionToggleHighlight extends GUIAction {

    public ActionToggleHighlight (JComponent target, Controller c) {
        super(target, c);

    }

    public void execute () {
        controller.toggleHighlight();
        controller.loadCode("");
    }

    @Override
    public void undoExecute () {

        execute();
    }

    @Override
    public void redoExecute () {

        execute();
    }

}
