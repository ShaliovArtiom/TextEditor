package listener;

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
        newPanel.addMouseListener(new MouseAdapter() {});

        //tabbedPane.removeTabAt(index);
    }

    private JPopupMenu createPopup() {
        JPopupMenu popup = new JPopupMenu();
        popup.add(cutActhion);
        popup.add(copyActhion);
        popup.add(pasteActhion);
        popup.addSeparator();
        popup.add(closePage);
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
    Action closePage = new AbstractAction("close this page") {
        public void actionPerformed(ActionEvent e) {
            int select = tabbedPane.getSelectedIndex();
            if (select >= 0) {
                tabbedPane.removeTabAt(select);
            }
        }
    };
}