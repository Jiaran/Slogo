package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.ActionRunAndClear;
import action.GUIAction;

public class RunAndClearFactory extends ActionFactory {

    public RunAndClearFactory (Controller controller) {
        super(controller);
        
    }

    @Override
    public GUIAction create(JComponent target) {
        if(target==null)
            return null;
        else
            return new ActionRunAndClear( target,controller);
    }
}
