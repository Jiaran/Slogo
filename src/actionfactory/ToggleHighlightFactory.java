package actionfactory;

import javax.swing.JComponent;
import controller.Controller;
import action.ActionToggleHighlight;
import action.GUIAction;

public class ToggleHighlightFactory extends ActionFactory {

    public ToggleHighlightFactory (Controller controller) {
        super(controller);
     
    }

    @Override
    public GUIAction create (JComponent target) {
        return new ActionToggleHighlight(target,controller);
    }

}
