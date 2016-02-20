package Menu;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by TyZiK on 20.02.2016.
 */
public class MenuFrame extends JFrame {
    public MenuFrame()
    {
        setTitle("TextEditor");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = fileMenu.add(new TestAction("New"));

        JMenuItem openItem = fileMenu.add(new TestAction("Open"));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));

        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        saveAsAction = new TestAction("Save As");
        JMenuItem saveAsItem = fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Exit") {

            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);

            }
        });

        readonlyItem = new JCheckBoxMenuItem("Read-only");
        readonlyItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event)
            {
                boolean saveOk = !readonlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);

            }
        });

        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);

        JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");

        group.add(insertItem);
        group.add(overtypeItem);

        Action cutAction = new TestAction("Cut");
        Action copyAction = new TestAction("Copy");
        Action pasteAction = new TestAction("Paste");

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);


        JMenu optionMenu = new JMenu("Options");

        optionMenu.add(readonlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overtypeItem);

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

        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);

        panel.addMouseListener(new MouseAdapter() {});
    }

    private  Action saveAction;
    private  Action saveAsAction;
    private  JCheckBoxMenuItem readonlyItem;
    private  JPopupMenu popup;

    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;
}

class TestAction extends AbstractAction
{
    public TestAction(String name) {super(name);}

    public void actionPerformed(ActionEvent event)
    {
        System.out.println(getValue(Action.NAME) + " selected.");

    }

}
