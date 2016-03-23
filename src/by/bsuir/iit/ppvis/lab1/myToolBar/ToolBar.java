package by.bsuir.iit.ppvis.lab1.myToolBar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Laptop on 07.03.16.
 */
public class ToolBar {
    private Action cutAction;
    private Action pasteAction;
    private Action copyAction;
    private Action fattyAction;
    private Action italicsAction;
    private Action underlinedAction;

    public ToolBar(JFrame frame) {
        createToolBar(frame);
    }

    public void createToolBar(JFrame frame) {
        String[] sizeOfWord = new String[]{"8", "9", "10", "11", "12", "13", "14", "16", "18", "20", "22",
                "24", "26", "28", "36", "48", "72"};
        JComboBox comboSize = new JComboBox(sizeOfWord);
        comboSize.setEditable(true);


        JComboBox comboStill = new JComboBox();
        String[] stillOfWord = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < stillOfWord.length; i++) {
            comboStill.addItem(stillOfWord[i]);
        }

        comboStill.setEditable(true);

        JToolBar bar = new JToolBar();
        frame.add(bar, BorderLayout.NORTH);
        bar.add(copyAction);
        bar.addSeparator();
        bar.add(pasteAction);
        bar.addSeparator();
        bar.add(cutAction);
        bar.addSeparator();
        bar.add(comboSize);
        bar.addSeparator();
        bar.add(comboStill);
        bar.addSeparator();
        bar.add(fattyAction);
        bar.add(italicsAction);
        bar.add(underlinedAction);
    }

    public void setCopyAction(Action copyAction) { this.copyAction = copyAction; }

    public void setCutAction(Action cutAction) { this.cutAction = cutAction; }

    public void setPasteAction(Action pasteAction) { this.pasteAction = pasteAction; }

    public void setFattyAction(Action fattyAction) { this.fattyAction = fattyAction; }

    public void setItalicsAction(Action italicsAction) { this.italicsAction = italicsAction; }

    public void setUnderlinedAction(Action underlinedAction) { this.underlinedAction = underlinedAction; }



}
