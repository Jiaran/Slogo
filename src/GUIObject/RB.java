package GUIObject;

import javax.swing.JRadioButtonMenuItem;

@SuppressWarnings("serial")
public class RB extends JRadioButtonMenuItem{
    private int index;
    public RB(int i){
        index=i;
        
    }
    public int getIndex(){
        return index;
    }
}
