package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

/**
 * Created by TyZiK on 20.02.2016.
 */

public class MenuFrame extends JFrame {
    public MenuFrame() {
        //menu

        setTitle("TextEditor");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //JTextPane jtp = new JTextPane();
        //add(jtp, BorderLayout.CENTER);

        //JTextField jtf = new JTextField();
        //add(jtf, BorderLayout.CENTER);

        JTextArea jta = new JTextArea();
        add(jta, BorderLayout.CENTER);
s
        JPanel panel = new JPanel();
        add(panel, BorderLayout.EAST);

        JPanel panel2 = new JPanel();
        add(panel2, BorderLayout.WEST);

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = fileMenu.add(new TestAction("New"));
        JMenuItem openItem = fileMenu.add(new TestAction("Open"));
        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);

        saveAsAction = new TestAction("Save As");
        JMenuItem saveAsItem = fileMenu.add(saveAsAction);
        fileMenu.addSeparator(); // Разделитель

        fileMenu.add(new AbstractAction("Exit") {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);

            }


        });

        readonlyItem = new JCheckBoxMenuItem("Read-only");
        readonlyItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                boolean saveOk = !readonlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);

            }
        });


        Action cutAction = new TestAction("Cut");
        Action copyAction = new TestAction("Copy");
        Action pasteAction = new TestAction("Paste");

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);


        JMenu optionMenu = new JMenu("Options");

        optionMenu.add(readonlyItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');

        JMenuItem indexItem = new JMenu("Index");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);

        JMenuItem aboutItem = new JMenu("About");
        indexItem.setMnemonic('A');
        helpMenu.add(aboutItem);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Всплывающее меню(от правой кнопки мыши)
        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        jta.setComponentPopupMenu(popup);
        jta.addMouseListener(new MouseAdapter() {});

        //toolbar

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

        pasteActhion.putValue(Action.SHORT_DESCRIPTION, "Pastte your text");

        String[] sizeOfWord = new String[]{"8" , "9" , "10" , "11" ,"12" , "13" ,"14" , "16" , "18" , "20" , "22" ,
                "24" , "26" , "28" , "36", "48" , "72"};
        JComboBox comboSize = new JComboBox(sizeOfWord);
        comboSize.setSelectedIndex(1);

        String[] stillOfWord = new String[]{"Still 1","Still2" };
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
        bar.add(copyActhion);
        bar.addSeparator();
        bar.add(pasteActhion);
        bar.addSeparator();
        bar.add(cutActhion);
        bar.addSeparator();
        bar.add(comboSize);
        bar.add(comboStill);
        bar.addSeparator();
        bar.add(fattyActhion);
        bar.add(italicsActhion);
        bar.add(underlinedActhion);
        add(bar, BorderLayout.NORTH);

    }
    private  Action saveAction;
    private  Action saveAsAction;
    private  JCheckBoxMenuItem readonlyItem;
    private  JPopupMenu popup;
    private JComboBox face;

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
