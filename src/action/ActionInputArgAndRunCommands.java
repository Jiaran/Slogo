package action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import controller.Controller;


public class ActionInputArgAndRunCommands extends ActionGetCodeAndRun {

    protected String inputDialogTitle = "Input Parameters";
    protected String inputDialogText = "Please input parameters\n"
                                       + "following the command prototype"
                                       + "Multiple parameters separated by blank space";

    public ActionInputArgAndRunCommands (JComponent target, Controller c) {
        super(target, c);

    }

    @Override
    public void execute () {
        String str = "";

        str = ((JTextComponent) target).getText();
        System.out.println(str);
        Pattern pattern =
                Pattern.compile("\\S+");
        Matcher matcher =
                pattern.matcher(str);
        int argCount = 0;
        matcher.find();
        String command = matcher.group();
        while (matcher.find()) {
            argCount++;
            System.out.println(matcher.group());
        }
        String args = "";
        if (argCount != 0)
            args = getInputDialog(argCount);
        if (args == null) { return; }
        code = generateCode(command, args);
        controller.loadCode(code);
    }

    protected String getInputDialog (int count) {
        String result =
                (String) JOptionPane.showInputDialog(
                                                     null,
                                                     inputDialogText,
                                                     inputDialogTitle,
                                                     JOptionPane.PLAIN_MESSAGE,
                                                     null,
                                                     null,
                                                     null);
        if (isValid(result, count)) {
            return result;
        }
        else {

            JOptionPane.showMessageDialog(
                                          null,
                                          "Sorry, Please input following correct format",
                                          "Invalid Format Parameters",
                                          JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    protected String generateCode (String command, String args) {
        return command + " " + args;
    }

    private boolean isValid (String result, int argCount) {
        if (result == null)
            return false;
        Pattern pattern =
                Pattern.compile("\\d+\\.*\\d*");
        Matcher matcher =
                pattern.matcher(result);

        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count == argCount;

    }

}
