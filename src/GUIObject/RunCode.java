package GUIObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.AbstractButton;
import javax.swing.JScrollPane;
import javax.swing.text.JTextComponent;


@SuppressWarnings("serial")
public class RunCode extends GUISection {

    public RunCode (JTextComponent co, AbstractButton runButton) {
        super("Run");

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(M_WIDTH, M_HEIGHT));
        this.setMinimumSize(new Dimension(M_WIDTH, M_HEIGHT));
        this.setVisible(true);
        bindInput(co);
        bindButton(runButton);

    }

    protected void bindInput (JTextComponent co) {
        JScrollPane paneScrollPane = new JScrollPane(co);
        paneScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        paneScrollPane.setPreferredSize(new Dimension(250, 100));
        this.add(paneScrollPane, BorderLayout.CENTER);
    }

    protected void bindButton (AbstractButton runButton) {
        runButton.setPreferredSize(new Dimension(80, 80));
        this.add(runButton, BorderLayout.EAST);

    }

}
