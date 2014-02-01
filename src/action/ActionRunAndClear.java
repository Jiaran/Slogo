package action;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import controller.Controller;


public class ActionRunAndClear extends ActionGetCodeAndRun {

    public ActionRunAndClear (JComponent target, Controller c) {
        super(target, c);
        // TODO Auto-generated constructor stub
    }

    public void execute () {
        super.execute();
        ((JTextComponent) target).setText("");
    }

}
