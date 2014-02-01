package GUIObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.Timer;




@SuppressWarnings("serial")
public class Display extends JPanel implements ActionListener, View {

    private final int DEFAULT_WIDTH = 800;
    private final int DEFAULT_HEIGHT = 500;
   
   
    private Collection<DisplayObject> myObjects = new HashSet<DisplayObject>();
    double myScaleFactor = 1.0;
    boolean gridON = false;
    private int DEFAULT_PERIOD = 60;
    private Timer timer = new Timer(DEFAULT_PERIOD, this);
    private int GRID_WIDTH = 100;
    private int GRID_HEIGHT = 100;
    private boolean isShowTurtleMessage = true;
    private String errorMessage = "";
    private String turtleMessage = "";

    public Display () {
        timer.setInitialDelay(0);
        timer.start();
        this.setFocusable(true);
//        this.addMouseListener(new MyListener());
//        this.addKeyListener(new MyKey());
        setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBackground(new Color(255, 255, 255));
        this.setVisible(true);

    }

    public Dimension getPreferredSize () {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (gridON) {
            drawGrid(g);
        }
        if (isShowTurtleMessage) {
            showTurtleMessage(g);
        }
        errorMessage(g, errorMessage);
        drawObject(g);

    }

    private void drawObject (Graphics g) {
        // transform to make sure everything is in the middle
        AffineTransform tra = new AffineTransform();

        tra.translate(getSize().getWidth() / 2, getSize().getHeight() / 2);
        tra.scale(myScaleFactor, myScaleFactor);
        Graphics2D g2 = (Graphics2D) g;
        g2.setTransform(tra);

        Iterator<DisplayObject> it = myObjects.iterator();
        while (it.hasNext()) {
            it.next().draw(g2);
        }
        tra.scale(1 / myScaleFactor, 1 / myScaleFactor);
        tra.translate(-getSize().getWidth() / 2, -getSize().getHeight() / 2);

        g2.setTransform(tra);

    }

    @Override
    public void actionPerformed (ActionEvent arg0) {

        repaint();

    }

    public Color changeBGColor (Color color) {
        Color result = this.getBackground();
        setBackground(color);
        return result;
    }

    public void toggleGrid () {
        gridON = !gridON;
    }

    private void drawGrid (Graphics g) {
        Dimension size = getSize();
        for (int i = 0; i * GRID_WIDTH < size.width; i++) {
            g.drawLine(i * GRID_WIDTH, 0, i * GRID_WIDTH, size.height);
        }
        for (int i = 0; i * GRID_HEIGHT < size.width; i++) {
            g.drawLine(0, i * GRID_HEIGHT, size.width, i * GRID_HEIGHT);
        }
    }

    public void addObject (DisplayObject d) {
        myObjects.add(d);
    }

    public void clean () {
        myObjects.clear();
    }

    public void toggleTurtleMessage () {
        isShowTurtleMessage = !isShowTurtleMessage;
    }

    private void showTurtleMessage (Graphics g) {
        g.drawString(turtleMessage, 10, 20);
    }

    private void errorMessage (Graphics g, String str) {
        g.setColor(Color.RED);
        g.drawString(str, 0, getSize().height);
        g.setColor(Color.BLACK);
    }

    public void setErrorMessage (String error) {
        errorMessage = error;
    }

    public void appendTurtleMessage (String str) {
        turtleMessage = turtleMessage + "   " + str;
    }

    public void clearTurtleMessage () {
        turtleMessage = "";
    }

    @Override
    public void updateView () {
        repaint();

    }

    public void zoomIn () {
        myScaleFactor += 0.3;
    }

    public void zoomOut () {
        if (myScaleFactor >= 1) {
            myScaleFactor -= 0.3;
        }

    }
    
//    private class MyListener extends MouseAdapter {
//        public void mouseClicked(MouseEvent e) {
//            
//           myController.loadCode("ONClICK "+e.getX()+" "+e.getY()+"\n");
//            System.out.println("clicked");
//        }
//        
//        public void mouseMoved(MouseEvent e) {
//            myController.loadCode("ONMOVE "+e.getX()+" "+e.getY()+"\n");
//         }
//
//
//    }
//    private class MyKey extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent e){
//            myController.loadCode("ONKEY "+e.getKeyCode()+"\n");
//            System.out.println("clicked");
//        }
//    }
    
}
