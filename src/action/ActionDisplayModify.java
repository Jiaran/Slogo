package action;

import javax.swing.JComponent;
import controller.Controller;
import GUIObject.Display;


public abstract class ActionDisplayModify extends GUIAction {
    public ActionDisplayModify (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    public void execute () {

        if (target instanceof Display) {
            modify();
        }

    }

    protected abstract void modify ();

    @Override
    public void undoExecute () {

        execute();
    }

    @Override
    public void redoExecute () {

        execute();
    }

}
