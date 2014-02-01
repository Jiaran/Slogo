package actionfactory;
import javax.swing.JComponent;
import controller.Controller;
import action.ActionGetCodeAndRun;
import action.GUIAction;


public class ActionGetCodeAndRunFactory extends ActionFactory{

    public ActionGetCodeAndRunFactory (Controller controller) {
        super(controller);
        
    }

    @Override
    public GUIAction create(JComponent target) {
        if(target==null)
            return null;
        else
            return new ActionGetCodeAndRun( target,controller);
    }

}
