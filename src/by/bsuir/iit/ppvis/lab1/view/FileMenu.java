package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Laptop on 07.03.16.
 */
public class FileMenu {

    private JMenuBar menuBar;
    private Action cutAction;
    private Action copyAction;
    private Action pasteAction;

    public FileMenu(JFrame frame){
        this.menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
    }

    public void createFileMenu( FileOpenListener fileOpenListener) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        openItem.addActionListener(fileOpenListener);
        fileMenu.addSeparator();


        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));


        JMenuItem saveAsItem = new JMenuItem("Save As");
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Exit") {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);
    }

    public void createEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        menuBar.add(editMenu);
    }

    public void setCopyAction(Action copyAction) { this.copyAction = copyAction; }

    public void setCutAction(Action cutAction) { this.cutAction = cutAction; }

    public void setPasteAction(Action pasteAction) { this.pasteAction = pasteAction; }


}
