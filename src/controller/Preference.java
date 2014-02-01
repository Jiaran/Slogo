package controller;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import GUIObject.Input;
import GUIObject.RunCode;


@SuppressWarnings("serial")
public class Preference extends JDialog {
    private Preference pr = this;
    private Menu myMenu;
    private int myWidth = 400;
    private int myHeight = 400;

    private JFileChooser jc;
    private JPanel myPanel = new JPanel();
    private JButton mySaveButton = new JButton("Save");
    private JButton myApplyButton = new JButton("Apply");
    private JButton myDefaultButton = new JButton("Default");
    private JButton addImage = new JButton("Add ");
    private JTextField myColorField = new JTextField();
    private JTextField myNumofTurtles = new JTextField();
    private JTextArea myImageList = new JTextArea();

    public Preference (JFrame owner, Menu m) {
        super(owner);
        myMenu = m;
        jc = myMenu.getChooser();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Preference");
        this.setMinimumSize(new Dimension(myWidth, myHeight));

        initialPanel();
        this.getContentPane().add(myPanel);

        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.setVisible(false);

    }

    private void initialPanel () {

        myPanel.setLayout(new GridBagLayout());

        mySaveButton.addActionListener(new saveAction());
        myDefaultButton.addActionListener(new defaultAction());
        myApplyButton.addActionListener(new applyAction());

        myImageList.setPreferredSize(new Dimension(100, 100));
        addImage.addActionListener(new addImageAction());

        RunCode rc = new RunCode(myImageList, addImage);
        rc.setmyTitle("Images List");

        JLabel l1 = new JLabel("Change the start Number of Turtles");
        JLabel l2 = new JLabel("Background Color. Specify using RGB value: R,G,B");

        JPanel buttons = new JPanel();
        buttons.add(mySaveButton);
        buttons.add(myApplyButton);
        buttons.add(myDefaultButton);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        c.weighty = 0.6;
        myPanel.add(rc, c);
        c.gridy += 1;
        myPanel.add(new Input("Number of Turtles", l1, myNumofTurtles), c);
        c.gridy += 1;
        myPanel.add(new Input("Background Color", l2, myColorField), c);

        c.gridy += 1;
        c.weighty = 0.6;

        myPanel.add(buttons, c);

    }

    private class saveAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            File file = null;
            if (jc.showSaveDialog(pr) == JFileChooser.APPROVE_OPTION) {
                file = jc.getSelectedFile();
                pr.checkAndSave(file);
            }
            else return;

        }
    }

    private class addImageAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            File file = null;
            if (jc.showSaveDialog(pr) == JFileChooser.APPROVE_OPTION) {
                file = jc.getSelectedFile();
                String str = myImageList.getText();
                str = str + "\n" + file.getAbsolutePath();
                myImageList.setText(str);
            }
            else return;

        }
    }

    private class defaultAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {

            myImageList.setText("");
            myColorField.setText("255,255,255");
            myNumofTurtles.setText("1");

        }
    }

    private class applyAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            File file = new File("start.pr");
            pr.checkAndSave(file);
            myMenu.getCurrentController().setPreference("start.pr");
        }
    }

    private void checkAndSave (File file) {
        BufferedWriter out = null;
        try {

            List<String> output = new ArrayList<String>();
            if (check(output)) {
                out = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < output.size(); i++) {
                    out.write(output.get(i));
                    out.newLine();
                }
                this.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(this, "Format incorrect");
            }

            out.close();
        }
        catch (IOException e) {
            return;
        }

    }

    private boolean check (List<String> output) {
        String str = myImageList.getText();
        String[] strs = str.split("\n+");
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].equals(""))
                output.add("image," + strs[i] + "\n");
        }
        str = myColorField.getText();
        if (!str.matches("\\W*\\d+\\W*,?\\W*\\d+\\W*,?\\W*\\d+\\W*,?")) {

            return false;
        }
        else {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);
            String rgb = "";
            while (matcher.find()) {
                rgb += matcher.group() + ",";

            }
            output.add("color," + rgb + "\n");
            str = myNumofTurtles.getText();
            output.add("numTurtle," + str + "\n");
            return str.matches("\\W*\\d+\\W*");

        }
    }

}
