package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.GUIAction;
import action.ModifyPenColor;

public class ModifyPenFactory extends ActionFactory {

   

    public ModifyPenFactory (Controller controller) {
        super(controller);
       
    }

    @Override
    public GUIAction create (JComponent target) {
        return new ModifyPenColor(target,controller);
    }
}
