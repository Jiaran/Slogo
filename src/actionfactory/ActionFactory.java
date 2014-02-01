package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.GUIAction;


public abstract class ActionFactory {
    protected Controller controller;

    public ActionFactory (Controller controller) {
        this.controller = controller;
    }

    public abstract GUIAction create (JComponent target);
}
