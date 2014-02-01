package GUIObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


@SuppressWarnings("serial")
public class Output extends GUISection {
    final static int extraWindowWidth = 100;
    private JTabbedPane tabbedPane = new JTabbedPane();

    public Output (String title) {
        super(title);
        setLayout(new BorderLayout());
    }

    public void addComponents (JComponent com, String tab) {
        JScrollPane paneScrollPane = new JScrollPane(com);
        paneScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        tabbedPane.addTab(tab, paneScrollPane);
        add(tabbedPane, BorderLayout.CENTER);

    }

}
