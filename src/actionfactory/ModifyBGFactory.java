package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.GUIAction;
import action.ModifyBGColor;

public class ModifyBGFactory extends ActionFactory {

    public ModifyBGFactory (Controller controller) {
        super(controller);
        // TODO Auto-generated constructor stub
    }

    @Override
    public GUIAction create (JComponent target) {
        return new ModifyBGColor(target,controller);
    }

}
