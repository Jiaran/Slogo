package actionfactory;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import controller.Controller;
import action.ActionEditVariable;
import action.GUIAction;

public class EditVariableFactory extends ActionFactory{

    public EditVariableFactory (Controller controller) {
        super(controller);
        
    }
    
    public GUIAction create (JComponent target) {
        
        if(!(target instanceof JTextComponent))
            return null;
        else
            return new ActionEditVariable( target,controller);
    }

}
