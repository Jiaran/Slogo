package actionfactory;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import controller.Controller;
import action.ActionInputArgAndRunCommands;
import action.GUIAction;

public class InputArgAndRunCommandsFactory extends ActionFactory {

    public InputArgAndRunCommandsFactory (Controller controller) {
        super(controller);
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public GUIAction create(JComponent target) {
        if(!(target instanceof JTextComponent))
            return null;
        else
            return new ActionInputArgAndRunCommands( target,controller);
    }

}
