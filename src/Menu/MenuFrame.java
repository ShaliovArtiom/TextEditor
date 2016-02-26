package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by TyZiK on 20.02.2016.
 */

public class MenuFrame{
    public MenuFrame(JFrame frame) {

        frame.setTitle("TextEditor");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //JTextPane jtp = new JTextPane();
        //add(jtp, BorderLayout.CENTER);

        //JTextField jtf = new JTextField();
        //add(jtf, BorderLayout.CENTER);

       //JTextArea jta = new JTextArea();
        //add(jta, BorderLayout.CENTER);

      //  JComponent jc = new JComponent(){

        //    WordScan word = new WordScan();
        //};
        //jc.setBackground(Color.WHITE);
        //add(jc, BorderLayout.CENTER);

        JPanel pl = new JPanel();
        pl.setBackground(Color.WHITE);
        frame.add(pl, BorderLayout.CENTER);


        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.EAST);

        JPanel panel2 = new JPanel();
        frame.add(panel2, BorderLayout.WEST);

        Action copyActhion = new AbstractAction("Copy", new ImageIcon("copy.jpeg")) {
            public void actionPerformed(ActionEvent e) {

            }
        };

        copyActhion.putValue(Action.SHORT_DESCRIPTION, "Copy your text");

        Action cutActhion = new AbstractAction("Cut", new ImageIcon("cut.jpeg")) {
            public void actionPerformed(ActionEvent e) {

            }
        };

        cutActhion.putValue(Action.SHORT_DESCRIPTION, "Cut your text");

        Action pasteActhion = new AbstractAction("Paste", new ImageIcon("paste.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenuItem newItem = fileMenu.add(new TestAction("New"));
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

        JMenuItem openItem = fileMenu.add(new TestAction("Open"));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        fileMenu.add(new AbstractAction("Save As") {

            public void actionPerformed(ActionEvent event) {
            }
        });

        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Exit") {

            public void actionPerformed(ActionEvent event) {
               System.exit(0);

            }
        });

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        editMenu.add(cutActhion);
        editMenu.add(copyActhion);
        editMenu.add(pasteActhion);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);


        pasteActhion.putValue(Action.SHORT_DESCRIPTION, "Pastte your text");

        popup = new JPopupMenu();
        popup.add(cutActhion);
        popup.add(copyActhion);
        popup.add(pasteActhion);

        pl.setComponentPopupMenu(popup);
        pl.addMouseListener(new MouseAdapter() {
        });



        String[] sizeOfWord = new String[]{"8" , "9" , "10" , "11" ,"12" , "13" ,"14" , "16" , "18" , "20" , "22" ,
                "24" , "26" , "28" , "36", "48" , "72"};
        JComboBox comboSize = new JComboBox(sizeOfWord);
        comboSize.setSelectedIndex(1);

        String[] stillOfWord = new String[]{"Still 1","Still2", "Still3" };
        JComboBox comboStill = new JComboBox(stillOfWord);
        comboStill.setSelectedIndex(1);

        Action fattyActhion = new AbstractAction("fatty", new ImageIcon("fatty.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };

        Action italicsActhion = new AbstractAction("italics", new ImageIcon("italics.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };


        Action underlinedActhion = new AbstractAction("underlined", new ImageIcon("underlined.jpeg")) {
            public void actionPerformed(ActionEvent e) {
            }
        };

        JToolBar bar = new JToolBar();
        frame.add(bar, BorderLayout.NORTH);
        bar.add(copyActhion);
        bar.addSeparator();
        bar.add(pasteActhion);
        bar.addSeparator();
        bar.add(cutActhion);
        bar.addSeparator();
        bar.add(comboSize);
        bar.addSeparator();
        bar.add(comboStill);
        bar.addSeparator();
        bar.add(fattyActhion);
        bar.add(italicsActhion);
        bar.add(underlinedActhion);

    }

    private  Action saveAction;
    private  Action saveAsAction;
    private  JPopupMenu popup;


    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;

}

class TestAction extends AbstractAction {
    public TestAction(String name) {
        super(name);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(getValue(Action.NAME) + " selected.");

    }


}
