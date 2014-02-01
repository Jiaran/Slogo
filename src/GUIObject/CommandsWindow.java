package GUIObject;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextField;
import actionfactory.ActionFactory;



@SuppressWarnings("serial")
public class CommandsWindow extends JPanel implements View {

    private final int ITEM_HEIGHT = 30;
    private ActionFactory actionFac;
    private String buttonName;
    private List<String> myStrings = null;

    public CommandsWindow (ActionFactory act, String buttonName) {
        actionFac = act;
        this.buttonName = buttonName;
        // setLayout( new GridLayout(0,2));
        setLayout(new GridBagLayout());
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setVisible(true);
    }

    public void setStrings (List<String> strings) {
        myStrings = strings;
    }

    private void createGUI (List<String> strings) {
        if (strings == null) { return; }
        this.setPreferredSize(new Dimension(300, ITEM_HEIGHT * strings.size()));

        for (int i = 0; i < strings.size(); i++) {
            // System.out.println(strings.get(i)+"\n");
            JTextField tempText = new JTextField();
            tempText.setText(strings.get(i));
            tempText.setEditable(false);
            tempText.setPreferredSize(new Dimension(100, ITEM_HEIGHT));

            tempText.setMinimumSize(new Dimension(150, ITEM_HEIGHT));
            GUIButton button = new GUIButton(actionFac.create(tempText), buttonName);
            button.setPreferredSize(new Dimension(80, ITEM_HEIGHT));
            button.setMinimumSize(new Dimension(80, ITEM_HEIGHT));
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i;
            c.weightx = 0.6;
            c.anchor = GridBagConstraints.PAGE_START;
            add(tempText, c);
            c.gridx = 1;
            c.weightx = 0.4;
            add(button, c);

        }
    }

    @Override
    public void updateView () {
        removeAll();
        createGUI(myStrings);
        revalidate();

    }

}
