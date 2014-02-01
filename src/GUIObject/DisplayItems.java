package GUIObject;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class DisplayItems extends JPanel implements View {

    private List<DisplayObject> myItems = null;
    private int ITEM_HEIGHT = 50;

    public DisplayItems () {

        setLayout(new GridBagLayout());

        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setVisible(true);
    }

    private void createGUI (List<DisplayObject> items) {
        if (items == null)
            return;
        this.setPreferredSize(new Dimension(300, ITEM_HEIGHT * items.size()));
        for (int i = 0; i < items.size(); i++) {
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i;
            c.weightx = 0.4;
            c.anchor = GridBagConstraints.CENTER;

            JLabel l = new JLabel("ID: " + i);

            add(l, c);
            c.gridx = 1;
            c.weightx = 0.6;
            add(new SimplePanel(items.get(i)), c);

        }
    }

    public void setItems (List<DisplayObject> items) {
        myItems = items;
    }

    @Override
    public void updateView () {
        removeAll();
        createGUI(myItems);
        repaint();
        revalidate();

    }
}
