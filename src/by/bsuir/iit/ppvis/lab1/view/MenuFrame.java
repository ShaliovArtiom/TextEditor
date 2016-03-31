package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//import element.Glyph;

/**
 * Created by Shaliov.Artiom on 20.02.2016.
 */

public class MenuFrame {

    private Document doc;

    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;

    public MenuFrame(JFrame frame) {
        frame.setTitle("TextEditor");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

//        Action fattyAction = new AbstractAction("fatty", new ImageIcon("fatty.jpeg")) {
//            public void actionPerformed(ActionEvent e) {
////                doc = new Document();
////                doc.fatty();
//            }
//        };
//
//        Action italicsAction = new AbstractAction("italics", new ImageIcon("italics.jpeg")) {
//            public void actionPerformed(ActionEvent e) {
//            }
//        };

       // Action underlinedAction = new AbstractAction("underlined", new ImageIcon("underlined.jpeg")) {
       //     public void actionPerformed(ActionEvent e) {
       //     }
       // };

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

        FileOpenListener fileOpenListener = new FileOpenListener();

        FileMenu menuBar = new FileMenu(frame);
        menuBar.setCopyAction(copyAction);
        menuBar.setCutAction(cutAction);
        menuBar.setPasteAction(pasteAction);
        menuBar.createFileMenu(fileOpenListener);
        menuBar.createEditMenu();

        ToolBarCreater toolBar = new ToolBarCreater();
        toolBar.setCutAction(cutAction);
        toolBar.setCopyAction(copyAction);
        toolBar.setPasteAction(pasteAction);
//        toolBar.setFattyAction(fattyAction);
//        toolBar.setItalicsAction(italicsAction);
        //toolBar.setUnderlinedAction(underlinedAction);
        toolBar.createToolBar(frame);

        Document doc = new Document();
        frame.add(doc, BorderLayout.CENTER);
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


