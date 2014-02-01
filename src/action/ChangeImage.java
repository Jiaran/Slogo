package action;

import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import controller.Controller;


public class ChangeImage extends ActionDisplayModify {
    File file = null;

    public ChangeImage (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    protected void modify () {
        JFileChooser fc = new JFileChooser("choose file for turtle");
        fc.setCurrentDirectory(new File("./"));
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            controller.loadImage(file);

        }
    }

    @Override
    public void undoExecute () {

        controller.undoLoadImage();
    }

    @Override
    public void redoExecute () {

        controller.loadImage(file);
    }

}
