package by.bsuir.iit.ppvis.lab1.menu;

import by.bsuir.iit.ppvis.lab1.fileMenu.MyFileMenu;
import by.bsuir.iit.ppvis.lab1.listener.FileOpenListener;
import by.bsuir.iit.ppvis.lab1.listener.MyKeyListener;
import by.bsuir.iit.ppvis.lab1.listener.NewPageListener;
import by.bsuir.iit.ppvis.lab1.myToolBar.ToolBar;
import element.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Shaliov.Artiom on 20.02.2016.
 */

public class MenuFrame {

    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;

    public MenuFrame(JFrame frame) {
        frame.setTitle("TextEditor");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Action fattyAction = new AbstractAction("fatty", new ImageIcon("fatty.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };

        Action italicsAction = new AbstractAction("italics", new ImageIcon("italics.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };

        Action underlinedAction = new AbstractAction("underlined", new ImageIcon("underlined.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };

        Action copyAction = new AbstractAction("Copy", new ImageIcon("copy.jpeg")) {
            public void actionPerformed(ActionEvent e) {
//                copy();
            }
        };
        copyAction.putValue(Action.SHORT_DESCRIPTION, "Copy your text");

        Action cutAction = new AbstractAction("Cut", new ImageIcon("cut.jpeg")) {
            public void actionPerformed(ActionEvent e) {

            }
        };
        cutAction.putValue(Action.SHORT_DESCRIPTION, "Cut your text");

        Action pasteAction = new AbstractAction("Paste", new ImageIcon("paste.jpeg")) {
            public void actionPerformed(ActionEvent e) {
//                paste();
            }
        };
        pasteAction.putValue(Action.SHORT_DESCRIPTION, "Pastte your text");

        NewPageListener pageListener = new NewPageListener(frame);
        pageListener.setCopyAction(copyAction);
        pageListener.setCutAction(cutAction);
        pageListener.setPasteAction(pasteAction);

        FileOpenListener fileOpenListener = new FileOpenListener();

        MyFileMenu menuBar = new MyFileMenu(frame);
        menuBar.setCopyAction(copyAction);
        menuBar.setCutAction(cutAction);
        menuBar.setPasteAction(pasteAction);
        menuBar.createFileMenu(pageListener, fileOpenListener);
        menuBar.createEditMenu();

        ToolBar toolBar = new ToolBar(frame);
        toolBar.setCutAction(cutAction);
        toolBar.setCopyAction(copyAction);
        toolBar.setPasteAction(pasteAction);
        toolBar.setFattyAction(fattyAction);
        toolBar.setItalicsAction(italicsAction);
        toolBar.setUnderlinedAction(underlinedAction);
        toolBar.createToolBar(frame);

        Element element = new Element();
        MyKeyListener mk = new MyKeyListener(frame);
        mk.init();
    }


//        private void copy() {
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        String text = textArea.getSelectedText();
//        if (text == null) text = textArea.getText();
//        StringSelection selection = new StringSelection(text);
//        clipboard.setContents(selection, null);
//
//    }


//    private void paste() {
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        DataFlavor flavor = DataFlavor.stringFlavor;
//        if (clipboard.isDataFlavorAvailable(flavor)) {
//            try {
//                String text = (String) clipboard.getData(flavor);
//                textArea.replaceSelection(text);
//            } catch (UnsupportedFlavorException e) {
//                JOptionPane.showMessageDialog(this, e);
//            } catch (IOException e) {
//                JOptionPane.showMessageDialog(this, e);
//            }
//        }
//    }

}


