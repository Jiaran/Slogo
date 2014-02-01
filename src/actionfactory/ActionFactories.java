package actionfactory;
import java.util.HashMap;
import controller.Controller;


public class ActionFactories {
    private HashMap<String, ActionFactory> map= new HashMap<String ,ActionFactory>();
    public ActionFactories(Controller controller){
        map.put("GetCodeAndRun", new ActionGetCodeAndRunFactory(controller));
        map.put("ModifyBG", new ModifyBGFactory(controller));
        map.put("ModifyPen", new ModifyPenFactory(controller));
        map.put("ModifyGrid", new ModifyGridFactory(controller));
        map.put("ChangeImage", new ChangeIMGFactory(controller));
        map.put("ShowTurtleMessage", new ShowTurtleMessageFactory(controller));
        map.put("RunAndClear", new RunAndClearFactory(controller));
        map.put("InputAndRun", new InputArgAndRunCommandsFactory(controller));
        map.put("EditVariable", new EditVariableFactory(controller));
        map.put("ToggleHighlight",new ToggleHighlightFactory(controller));
    }
    
    public ActionFactory get(String key){
        return map.get(key);
    }
}
