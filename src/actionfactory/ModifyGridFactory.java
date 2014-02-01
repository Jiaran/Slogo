package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.GUIAction;
import action.ModifyGrid;

public class ModifyGridFactory extends ActionFactory {

    public ModifyGridFactory (Controller controller) {
        super(controller);
        
    }

    @Override
    public GUIAction create (JComponent target) {
        return new ModifyGrid(target,controller);
    }
}
