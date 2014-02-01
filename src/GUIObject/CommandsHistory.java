package GUIObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.text.JTextComponent;


@SuppressWarnings("serial")
public class CommandsHistory extends RunCode implements View {
    private JTextComponent myDisplay = null;
    private String myString = "";

    public CommandsHistory (JTextComponent co, GUIButton runButton) {
        super(co, runButton);
        myDisplay = co;
        co.setEditable(false);

    }

    @Override
    protected void bindButton (AbstractButton runButton) {
        runButton.setMaximumSize(new Dimension(80, 80));
        this.add(runButton, BorderLayout.SOUTH);

    }

    public void setStrings (List<String> s) {

        myString = "";
        for (int i = 0; i < s.size(); i++) {
            myString = myString + s.get(i) + "\n";
        }
    }

    @Override
    public void updateView () {

        myDisplay.setText(myString);
    }
}
