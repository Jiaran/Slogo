package controller;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.Trail;
import model.TurtleStamp;
import modelAPI.Data;
import modelAPI.ModelAPI;
import GUIObject.ColorDisplay;
import GUIObject.CommandsHistory;
import GUIObject.CommandsWindow;
import GUIObject.Display;
import GUIObject.DisplayItems;
import GUIObject.DisplayObject;
import GUIObject.GUIButton;
import GUIObject.HalfScreen;
import GUIObject.ImageDisplay;
import GUIObject.MainWindow;
import GUIObject.Output;
import GUIObject.RunCode;
import GUIObject.Settings;
import GUIObject.TrailDisplay;
import GUIObject.TurtleDisplay;
import GUIObject.View;
import action.GUIAction;
import actionfactory.ActionFactories;


@SuppressWarnings("serial")
public class Controller extends JPanel {

    private HashMap<String, View> allViews = new HashMap<String, View>();
    private List<Image> images = new ArrayList<Image>();
    Locale[] supportedLocales = {
                                 Locale.ENGLISH,
                                 Locale.FRENCH,
                                 Locale.ITALIAN,
                                 Locale.CHINESE
    };
    private ActionFactories actionMap = new ActionFactories(this);
    private ModelAPI myModelAPI = new ModelAPI();
    private Display display = new Display();
    private RunCode runCode = null;
    private Output output = new Output("OUTPUT");
    private Settings settings = new Settings("SETTINGS");
    boolean canHighlight = true;

    private boolean canRedo = false;
    private boolean canUndo = false;
    private GUIAction undo = null;

    {
        allViews.put("Display", display);
    }

    public Controller () {
        initialGUI();
        this.setVisible(true);
    }

    private void initialGUI () {

        myModelAPI.setLocale(supportedLocales[0]);
        JTextArea co = new JTextArea();
        GUIAction act = this.actionMap.get("RunAndClear").create(co);
        GUIButton gb = new GUIButton(act, "RUN");
        runCode = new RunCode(co, gb);

        // ////

        try {
            initialGUISection("settings.txt", new InitialSettings());
            initialGUISection("output.txt", new InitialOutput());
            initialGUISection("start.pr", new InitialPreference());
        }
        catch (IOException e) {
            System.out.println("fail to initialize, please check initial files");
            System.exit(1);
        }

        HalfScreen hf = new HalfScreen(display, runCode);

        HalfScreen hf1 = new HalfScreen(settings, output);

        MainWindow mw = new MainWindow(hf1, hf);
        add(mw);
        loadCode("");

        // TurtleDisplay td= new TurtleDisplay(300, 300,canHighlight);
        // display.addObject(td);

    }

    public void setPreference (String preferenceFileName) {
        try {
            initialGUISection(preferenceFileName, new InitialPreference());
        }
        catch (IOException e) {
            System.out.println("fail to change Preference");
            System.exit(1);
        }

    }

    public void loadCode (String str) {
        myModelAPI.loadCode(str);
        updateViews(myModelAPI.getData());

    }

    private void updateViews (Data data) {
        display.clean();
        display.setBackground(data.readBGColor());
        CommandsWindow va = (CommandsWindow) allViews.get("Variables");
        va.setStrings(data.readVariables());
        CommandsWindow usercommands = (CommandsWindow) allViews.get("UserCommands");
        usercommands.setStrings(data.readCommands());
        CommandsHistory ch = (CommandsHistory) allViews.get("CommandsHistory");
        ch.setStrings(data.readHistory());
        display.setErrorMessage(data.readErrors());
        translateTurtleInfo(data);
        translateColorInfo(data);
        setImageList();

        Iterator<Entry<String, View>> it = allViews.entrySet().iterator();
        while (it.hasNext()) {
            View v = (View) it.next().getValue();
            v.updateView();
        }

    }

    private void translateTurtleInfo (Data data) {
        display.clearTurtleMessage();

        List<TurtleStamp> list = data.readStamps();
        display.setBackground(data.readBGColor());
        for (int i = 0; i < list.size(); i++) {
            if (data.readTurtleVisibility(i)) {
                TurtleDisplay t =
                        new TurtleDisplay(list.get(i).readX(), list.get(i).readX(), canHighlight,
                                          list.get(i).readAngle());
                if (data.readActiveTurtleIDs().contains(i))
                    t.setActive(true);
                t.setImage(getImage(list.get(i).readImageID()));
                display.addObject(t);
                readTrails(data.readTrails(i));

                display.appendTurtleMessage(t.toString());
            }
        }
        Iterator<Integer> it = data.readTurtleIDs().iterator();
        System.out.println(data.readTurtleIDs());
        while (it.hasNext()) {
            int i = it.next();
            if (data.readTurtleVisibility(i)) {
                TurtleDisplay t =
                        new TurtleDisplay(data.readTurtleX(i), data.readTurtleY(i), canHighlight,
                                          data.readTurtleAngle(i));
                if (data.readActiveTurtleIDs().contains(i))
                    t.setActive(true);
                t.setImage(getImage(data.readImageID(i)));
                display.addObject(t);
                readTrails(data.readTrails(i));

                display.appendTurtleMessage(t.toString());
            }
        }

    }

    private void translateColorInfo (Data data) {
        DisplayItems co = (DisplayItems) allViews.get("Colors");
        List<DisplayObject> items = new ArrayList<DisplayObject>();
        List<Color> colors = data.readColors();
        for (int i = 0; i < colors.size(); i++) {
            items.add(new ColorDisplay(colors.get(i)));
        }
        co.setItems(items);

    }

    private void readTrails (List<Trail> trails) {
        for (Trail t : trails) {
            TrailDisplay td = new TrailDisplay(t.readFirstCoords()[0], t.readFirstCoords()[1],
                                               t.readThickness(), t.readColor());
            td.setPosition(t.readSecondCoords()[0], t.readSecondCoords()[1]);
            display.addObject(td);

        }

    }

    public void loadImage (File imgFile) {

        addImage(imgFile);
        String code = "setsh " + (images.size() - 1);
        loadCode(code);
    }

    public void undoLoadImage () {
        images.remove(images.size() - 1);
        undoLoadCode();
    }

    public void changePenColor (Color color) {
        int size = myModelAPI.getData().readColors().size();
        String code =
                "setpalette " + size + " " + color.getRed() + " " + color.getGreen() + " " +
                        color.getBlue() +
                        " ";
        code = code + "\n" + "setpencolor " + size + " ";
        loadCode(code);

    }

    public Color changeBGColor (Color color) {
        Color result = display.getBackground();
        String code =
                "setpalette 0 " + color.getRed() + " " + color.getGreen() + " " + color.getBlue() +
                        " ";
        code = code + "\n" + "setbackground 0";
        loadCode(code);
        return result;

    }

    private void initialGUISection (String filename, InitialMethod im) throws IOException {
        BufferedReader in = getStream(filename);
        String s;
        while ((s = in.readLine()) != null) {
            String[] parameters = s.split(",");
            im.invoke(parameters);
        }
        in.close();
    }

    private abstract class InitialMethod {
        abstract void invoke (String[] strings);
    }

    private class InitialSettings extends InitialMethod {
        void invoke (String[] parameters) {

            GUIButton b =
                    new GUIButton(actionMap.get(parameters[1]).create(display), parameters[0]);
            settings.addComponent(b);
        }
    }

    private class InitialOutput extends InitialMethod {
        void invoke (String[] parameters) {
            JComponent tab = null;
            if (parameters[0].equals("CommandsHistory")) {
                JTextArea co1 = new JTextArea();
                GUIAction act1 = actionMap.get("GetCodeAndRun").create(co1);
                GUIButton gb1 = new GUIButton(act1, "run history commands");
                tab = new CommandsHistory(co1, gb1);

            }
            else if (parameters[0].equals("CommandsWindow")) {
                // 1 tab name, 2 actionName, 3 buttonText

                tab = new CommandsWindow(actionMap.get(parameters[2]), parameters[3]);

            }
            else if (parameters[0].equals("DisplayItems")) {

                tab = new DisplayItems();

            }
            allViews.put(parameters[1], (View) tab);
            output.addComponents(tab, parameters[1]);

        }
    }

    private class InitialPreference extends InitialMethod {
        void invoke (String[] parameters) {
            if (parameters[0].equals("color")) {

                display.setBackground(new Color(Integer.parseInt(parameters[1]), Integer
                        .parseInt(parameters[2]), Integer.parseInt(parameters[3])));

            }
            else if (parameters[0].equals("numTurtle")) {
                myModelAPI = new ModelAPI();
                for (int i = 0; i < Integer.parseInt(parameters[1]); i++) {
                    myModelAPI.addTurtle(i);
                }
            }
            else if (parameters[0].equals("image")) {
                addImage(parameters[1]);
            }

        }
    }

    public void addImage (File imgFile) {
        Image img;

        try {
            img = ImageIO.read(imgFile);
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        images.add(img);
    }

    public void addImage (String filename) {
        File file = new File(filename);
        addImage(file);
    }

    private Image getImage (int i) {
        if (i >= images.size())
            return null;
        else if (i == -1) { return null; }
        return images.get(i);
    }

    private BufferedReader getStream (String filename) {

        File file = new File(filename);
        return getStream(file);

    }

    private BufferedReader getStream (File file) {

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            return in;
        }
        catch (IOException e) {
            return null;
        }

    }

    private void setImageList () {
        List<DisplayObject> items2 = new ArrayList<DisplayObject>();

        DisplayItems im = (DisplayItems) allViews.get("Images List");
        for (int i = 0; i < images.size(); i++) {
            items2.add(new ImageDisplay(images.get(i)));

        }
        im.setItems(items2);
    }

    public void toggleHighlight () {
        canHighlight = !canHighlight;
    }

    public void redo () {
        undo.redo();
    }

    public void undo () {
        undo.undo();
    }

    public void undoLoadCode () {
        myModelAPI.undo();
        myModelAPI.loadCode("");
    }

    public void setUndo (GUIAction a) {
        undo = a;
    }

    public boolean isCanRedo () {
        return canRedo;
    }

    public void setCanRedo (boolean canRedo) {
        this.canRedo = canRedo;
    }

    public boolean isCanUndo () {
        return canUndo;
    }

    public void setCanUndo (boolean canUndo) {
        this.canUndo = canUndo;
    }

    @SuppressWarnings("unchecked")
    public void saveLib (File f) {
        List<String> va = myModelAPI.getData().readVariables();
        for (int i = 0; i < va.size(); i++) {
            va.set(i, "make " + va.get(i));
        }
        String str =
                wrapStringList(myModelAPI.getData().readLibrary(), va);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            out.write(str);
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadLib (File f) {
        BufferedReader in = getStream(f);
        String code = "";
        String str = "";
        try {
            while ((str = in.readLine()) != null) {
                code = code + "\n" + str;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(code);
        loadCode(code);
    }

    public String wrapStringList (@SuppressWarnings("unchecked") List<String> ... args) {
        String str = "";
        for (List<String> list : args) {
            for (int i = 0; i < list.size(); i++) {
                str = str + System.getProperty("line.separator") + list.get(i);
            }
        }
        return str;
    }

    public void setLocale (int index) {
        myModelAPI.setLocale(supportedLocales[index]);

    }

    public void zoomIn () {
        display.zoomIn();
    }

    public void zoomOut () {
        display.zoomOut();
    }

}
