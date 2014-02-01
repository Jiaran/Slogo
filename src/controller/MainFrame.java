package controller;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    private Menu myMenu = new Menu(this);
    int currentWorkSpaceIndex = 0;
    
    private List<Controller> workSpaces = new ArrayList<Controller>();

    public MainFrame () {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SLogo");
       
      
        
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        addWorkSpace();
        setJMenuBar(myMenu);
        pack();
        this.setVisible(true);

    }

    public static void main (String[] args) {
        // Schedule a job for the event dispatching thread:
        // creating and showing this application's GUI.

        SwingUtilities.invokeLater(new Runnable() {
            public void run () {

                new MainFrame();
            }
        });

    }

    public void setCurrentWorkSpace (int i) {
        workSpaces.get(currentWorkSpaceIndex).setVisible(false);
        workSpaces.get(i).setVisible(true);
        
        myMenu.setController(workSpaces.get(i));
        currentWorkSpaceIndex = i;
        revalidate();
    }

    public void addWorkSpace () {
        Controller c = new Controller();
        this.getContentPane().add(c);

        workSpaces.add(c);
        setCurrentWorkSpace(workSpaces.size() - 1);
        myMenu.addWorkSpace(workSpaces.size() - 1);

    }

    public int numofWorkSpace () {
        return workSpaces.size();
    }
    
    
}
