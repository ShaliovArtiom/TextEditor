package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class ToolBarCreater {

    private Action cutAction;
    private Action pasteAction;
    private Action copyAction;
    private JComboBox size;
    private JComboBox face;
    private JCheckBox bold;
    private JCheckBox italic;
    private Font font;
    private DocumentView documentView;

    public ToolBarCreater(DocumentView documentView) {
        this.documentView = documentView;
    }

    public void createToolBar(JFrame frame) {

        ActionListener listener = new FontAction();

        size = new JComboBox(new String[]
                {
                        "10", "12", "15", "18", "24", "36"

                });

        size.addActionListener(listener);

        face = new JComboBox(new String[]
                {
                        "TimesNewRoman", "Serif", "SansSerif", "Dialod", "DialogInput"

                });
        face.addActionListener(listener);

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);

        JToolBar bar = new JToolBar();
        frame.add(bar, BorderLayout.NORTH);
        bar.add(copyAction);
        bar.addSeparator();
        bar.add(pasteAction);
        bar.addSeparator();
        bar.add(cutAction);
        bar.addSeparator();
        bar.add(size);
        bar.addSeparator();
        bar.add(face);
        bar.addSeparator();
        bar.add(bold);
        bar.add(italic);
        //  bar.add(underlinedAction);
    }

    public class FontAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            documentView.repaint();
            String fontFace = (String) face.getSelectedItem();
            int fontStyle = (bold.isSelected() ? Font.BOLD : 0) +
                    (italic.isSelected() ? Font.ITALIC : 0);

            int fontSize = Integer.parseInt((String) size.getSelectedItem());

            font = new Font(fontFace, fontStyle, fontSize);
            documentView.getDocument().setDefaultFont(font);
        }
    }

    public void setCopyAction(Action copyAction) {
        this.copyAction = copyAction;
    }

    public void setCutAction(Action cutAction) {
        this.cutAction = cutAction;
    }

    public void setPasteAction(Action pasteAction) {
        this.pasteAction = pasteAction;
    }
}
