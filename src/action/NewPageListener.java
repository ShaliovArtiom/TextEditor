package action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * Created by Laptop on 07.03.16.
 */
public class NewPageListener implements ActionListener {

    private JTabbedPane tabbedPane;
    private JPanel newPanel;

    private Action copyActhion;
    private Action cutActhion;
    private Action pasteActhion;

    public NewPageListener(JFrame frame) {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        frame.getContentPane().add(tabbedPane);
    }

    public void actionPerformed(ActionEvent event) {
        JPopupMenu popup = createPopup();
        newPanel = new JPanel();
        tabbedPane.add("Panel ", newPanel);
        newPanel.setBackground(Color.WHITE);

        newPanel.setComponentPopupMenu(popup);
        newPanel.addMouseListener(new MouseAdapter() {
        });
    }

    private JPopupMenu createPopup() {
        JPopupMenu popup = new JPopupMenu();
        popup.add(cutActhion);
        popup.add(copyActhion);
        popup.add(pasteActhion);
        return popup;
    }


    public void setCopyAction(Action copyActhion) {
        this.copyActhion = copyActhion;
    }

    public void setCutAction(Action cutActhion) {
        this.cutActhion = cutActhion;
    }

    public void setPasteAction(Action pasteActhion) {
        this.pasteActhion = pasteActhion;
    }
}