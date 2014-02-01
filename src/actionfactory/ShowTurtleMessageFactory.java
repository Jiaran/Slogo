package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.GUIAction;
import action.ShowTurtleMessage;

public class ShowTurtleMessageFactory extends ActionFactory {

    public ShowTurtleMessageFactory (Controller controller) {
        super(controller);
       
    }

    @Override
    public GUIAction create (JComponent target)  {
        return new ShowTurtleMessage(target,controller);
        
    }

}
