package by.bsuir.iit.ppvis.lab1.listener;

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

    private Action copyAction;
    private Action cutAction;
    private Action pasteAction;
    private int numberOfPage = 0;

    public NewPageListener(JFrame frame) {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.getContentPane().add(tabbedPane);
    }

    public void actionPerformed(ActionEvent event) {
        numberOfPage++;
        JPopupMenu popup = createPopup();
        newPanel = new JPanel();
        newPanel.setBackground(Color.WHITE);
        tabbedPane.add("Panel " + numberOfPage, newPanel);

        newPanel.setComponentPopupMenu(popup);
        newPanel.addMouseListener(new MouseAdapter() {
        });
    }

    private JPopupMenu createPopup() {
        JPopupMenu popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);
        popup.addSeparator();
        popup.add(closePage);
        popup.add(closeAllPage);
        return popup;
    }

    Action closePage = new AbstractAction("close this page") {
        public void actionPerformed(ActionEvent e) {
            int select = tabbedPane.getSelectedIndex();
            if (select >= 0) {
                tabbedPane.removeTabAt(select);
            }
        }
    };
    Action closeAllPage = new AbstractAction("close all page") {
        public void actionPerformed(ActionEvent e) {
            tabbedPane.removeAll();
            numberOfPage = 0;
        }
    };

    public void setCopyAction(Action copyAction) { this.copyAction = copyAction; }

    public void setCutAction(Action cutAction) { this.cutAction = cutAction; }

    public void setPasteAction(Action pasteAction) { this.pasteAction = pasteAction; }

}