package action;

import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import controller.Controller;
import java.awt.event.ActionListener;


;

abstract public class GUIAction implements ActionListener {
    Controller controller;
    JComponent target;

    public GUIAction (JComponent target, Controller c) {
        this.target = target;
        this.controller = c;
    }

    @Override
    public void actionPerformed (ActionEvent arg0) {
        controller.setCanUndo(true);
        controller.setCanRedo(false);
        controller.setUndo(this);
        execute();
    }

    public void undo () {
        controller.setCanRedo(true);
        controller.setCanUndo(false);
        undoExecute();
    }

    protected void undoExecute () {

    }

    public void redo () {
        controller.setCanUndo(true);
        controller.setCanRedo(false);
        redoExecute();
    }

    protected void redoExecute () {

    }

    public abstract void execute ();

    public void setTarget (JComponent target) {
        this.target = target;
    }

}
