package by.bsuir.iit.ppvis.lab1.fileMenu;

import by.bsuir.iit.ppvis.lab1.listener.FileOpenListener;
import by.bsuir.iit.ppvis.lab1.listener.NewPageListener;
import by.bsuir.iit.ppvis.lab1.listener.SaveAsListener;
import by.bsuir.iit.ppvis.lab1.listener.SaveListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Laptop on 07.03.16.
 */
public class MyFileMenu {

    private JMenuBar menuBar;
    private Action cutAction;
    private Action copyAction;
    private Action pasteAction;

    public MyFileMenu(JFrame frame){
        this.menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
    }

    public void createFileMenu(NewPageListener pageListener, FileOpenListener fileOpenListener) {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        newItem.addActionListener(pageListener);

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        openItem.addActionListener(fileOpenListener);
        fileMenu.addSeparator();

        SaveListener saveListener = new SaveListener();

        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveItem.addActionListener(saveListener);

        SaveAsListener saveAsListener = new SaveAsListener();

        JMenuItem saveAsItem = new JMenuItem("Save As");
        fileMenu.add(saveAsItem);
        fileMenu.addActionListener(saveAsListener);
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
