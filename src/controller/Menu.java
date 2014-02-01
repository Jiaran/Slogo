package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import GUIObject.LocaleRB;
import GUIObject.RB;
import GUIObject.WorkSpaceRB;


@SuppressWarnings("serial")
public class Menu extends JMenuBar {

    private MainFrame myFrame;
    private Controller myController;
    private JFileChooser prJC = new JFileChooser();
    private JFileChooser libJC = new JFileChooser();
    private JMenu mySwitchWorkSpace = new JMenu("Switch WorkSpace");
    private JMenu mySwitchLocale = new JMenu("Locale");
    private ButtonGroup workspaceGroup = new ButtonGroup();
    private ButtonGroup localeGroup = new ButtonGroup();
    private Preference pr = new Preference(myFrame, this);
    private JMenuItem undo = new JMenuItem("Undo");
    private JMenuItem redo = new JMenuItem("Redo");
    private RB[] localeRBs = { new LocaleRB(0, "English"),

                      new LocaleRB(1, "Franch"),

                      new LocaleRB(2, "Italian"),

                      new LocaleRB(3, "Chinese") };

    public Menu (MainFrame f) {
        myFrame = f;

        initial();
    }

    public void setController (Controller c) {
        myController = c;

    }

    public Controller getCurrentController () {
        return myController;
    }

    private void initial () {

        initialFileChooser(prJC, "Preference", "pr");
        initialFileChooser(libJC, "Library", "lib");
        JMenu edit = new JMenu("Edit");

        edit.addMenuListener(new editListener());

        undo.addActionListener(new undoAction());
        edit.add(undo);

        redo.addActionListener(new redoAction());
        edit.add(redo);
        
        JMenuItem zoomIn= new JMenuItem("Zoom In");
        edit.add(zoomIn);
        zoomIn.addActionListener(new zoomInAction());
        JMenuItem zoomOut= new JMenuItem("Zoom Out");
        zoomOut.addActionListener(new zoomOutAction());
        edit.add(zoomOut);
        JMenuItem createNewSpace = new JMenuItem("Create New WorkSpace");
        createNewSpace.addActionListener(new createAction());
        edit.add(createNewSpace);
        add(edit);

        JMenu pref = new JMenu("Preference");
        ;

        JMenuItem set = new JMenuItem("Set");
        set.addActionListener(new setAction());
        pref.add(set);

        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(new loadAction());
        pref.add(load);
        add(pref);

        add(mySwitchWorkSpace);

        for (int i = 0; i < 4; i++) {
            addLocale(localeRBs[i]);
        }

        add(mySwitchLocale);

        JMenu library = new JMenu("Library");
        JMenuItem libSave = new JMenuItem("Save Current Commands and Variables");
        libSave.addActionListener(new LibSaveAction());
        JMenuItem libLoad = new JMenuItem("Load Commands and Variables");
        libLoad.addActionListener(new LibLoadAction());
        library.add(libSave);
        library.add(libLoad);
        add(library);
    }

    private class LibSaveAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {

            if (libJC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = libJC.getSelectedFile();
                myController.saveLib(f);
            }

        }

    }

    private class LibLoadAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {

            if (libJC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = libJC.getSelectedFile();
                myController.loadLib(f);
            }

        }

    }

    private class undoAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            myController.undo();

        }

    }

    private class redoAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            myController.redo();

        }

    }

    private class createAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            myFrame.addWorkSpace();

        }

    }

    private class switchWorkSpaceAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            WorkSpaceRB item = (WorkSpaceRB) e.getSource();
            myFrame.setCurrentWorkSpace(item.getIndex());

        }
    }

    private class switchLocaleAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            RB item = (RB) e.getSource();

            myController.setLocale(item.getIndex());

        }
    }

    private class setAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            pr.setVisible(true);

        }

    }

    private class loadAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            if (prJC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = prJC.getSelectedFile();
                myController.setPreference(f.getName());
            }

        }

    }

    private class zoomInAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            myController.zoomIn();

        }

    }
    private class zoomOutAction implements ActionListener {

        @Override
        public void actionPerformed (ActionEvent e) {
            myController.zoomOut();

        }

    }
    private class editListener implements MenuListener {

        @Override
        public void menuCanceled (MenuEvent e) {

        }

        @Override
        public void menuDeselected (MenuEvent e) {

        }

        @Override
        public void menuSelected (MenuEvent e) {
            undo.setEnabled(myController.isCanUndo());
            redo.setEnabled(myController.isCanRedo());

        }

    }

    void addWorkSpace (int i) {
        WorkSpaceRB rbMenuItem = new WorkSpaceRB(i);

        rbMenuItem.addActionListener(new switchWorkSpaceAction());
        workspaceGroup.add(rbMenuItem);
        rbMenuItem.setSelected(true);
        mySwitchWorkSpace.add(rbMenuItem);

    }

    private void initialFileChooser (JFileChooser jc, String name, String extend) {
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter(
                                            name, extend);
        jc.setFileFilter(filter);
        jc.setCurrentDirectory(new File("./"));
    }

    public JFileChooser getChooser () {

        return prJC;
    }

    private void addLocale (RB rb) {
        rb.addActionListener(new switchLocaleAction());
        localeGroup.add(rb);
        mySwitchLocale.add(rb);

    }

}
