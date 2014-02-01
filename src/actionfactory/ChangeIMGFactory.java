package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.ChangeImage;
import action.GUIAction;

public class ChangeIMGFactory extends ActionFactory{

    public ChangeIMGFactory (Controller controller) {
        super(controller);
        // TODO Auto-generated constructor stub
    }
    
    public GUIAction create (JComponent target) {
        return new ChangeImage(target,controller);
    }

}
