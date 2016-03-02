package Menu;

import com.sun.glass.ui.CommonDialogs;
import org.omg.CORBA.BAD_INV_ORDER;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.awt.image.VolatileImage;
import java.io.File;
import java.io.FileFilter.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.*;
import java.io.IOException;
import java.security.cert.Extension;
import java.util.ArrayList;


/**
 * Created by TyZiK on 20.02.2016.
 */

public class MenuFrame extends Component {
    public MenuFrame(JFrame frame) {

        frame.setTitle("TextEditor");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

       /* JPanel pl = new JPanel();
        pl.setBackground(Color.WHITE);
        frame.add(pl, BorderLayout.CENTER);
*/
        textArea = new JTextArea();
        frame.add(textArea, BorderLayout.CENTER);

        JPanel panelRight = new JPanel();
        frame.add(panelRight, BorderLayout.EAST);

        JPanel panelLeft = new JPanel();
        frame.add(panelLeft, BorderLayout.WEST);


        Action copyActhion = new AbstractAction("Copy", new ImageIcon("copy.jpeg")) {
            public void actionPerformed(ActionEvent e) {
                copy();
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
                paste();
            }
        };


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        JMenuItem newItem = fileMenu.add(new ActionNewListener("New"));
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));


        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        openItem.addActionListener(new FileOpenListener());
        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        saveAsAction = new TestAction("Save As");
        JMenuItem saveAsItem = fileMenu.add(saveAsAction);
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

        textArea.setComponentPopupMenu(popup);
        textArea.addMouseListener(new MouseAdapter() {});



        String[] sizeOfWord = new String[]{"8" , "9" , "10" , "11" ,"12" , "13" ,"14" , "16" , "18" , "20" , "22" ,
                "24" , "26" , "28" , "36", "48" , "72"};
        JComboBox comboSize = new JComboBox(sizeOfWord);
        comboSize.setEditable(true);


        JComboBox comboStill = new JComboBox();
        String [] stillOfWord = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(int i = 0; i < stillOfWord.length; i++)
        {
            comboStill.addItem( stillOfWord[i]);
        }

        comboStill.setEditable(true);

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

        chooser = new JFileChooser();
        final ExtensionFileFilter filter = new ExtensionFileFilter();
        filter.addExtension("txt");
        filter.setDescription("Text files");
        chooser.setFileFilter(filter);

    }

    private class FileOpenListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            chooser.setCurrentDirectory(new File(".."));

            int result = chooser.showOpenDialog(MenuFrame.this);

            if(result == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();

            }
        }
    }

    private void copy()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = textArea.getSelectedText();
        if(text == null) text = textArea.getText();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);

    }


    private void paste()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if(clipboard.isDataFlavorAvailable(flavor)) {
            try {
                String text = (String) clipboard.getData(flavor);
                textArea.replaceSelection(text);
            } catch (UnsupportedFlavorException e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
            catch (IOException e)
            {
              JOptionPane.showMessageDialog(this, e);
            }
        }

    }


    private  Action saveAction;
    private  Action saveAsAction;
    private  JPopupMenu popup;
    private JFileChooser chooser;
    private JTextArea textArea;


    public static final int DEFAULT_HEIGHT = 600;
    public static final int DEFAULT_WIDTH = 800;

}

class ExtensionFileFilter extends FileFilter {

    public void addExtension(String extension)
    {
        if(!extension.startsWith("."))
            extension = "." + extension;
        extensions.add(extension.toLowerCase());

    }

    public void setDescription(String aDescription)
    {
        description = aDescription;

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) return true;
        String name = f.getName().toLowerCase();
        for(String extension : extensions)
            if(name.endsWith(extension))
                return true;
        return false;
    }

    private String description = "";
    private ArrayList<String> extensions = new ArrayList<String>();
}


class TestAction extends AbstractAction {
    public TestAction(String name) {
        super(name);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(getValue(Action.NAME) + " selected.");

    }
}

class ActionNewListener extends AbstractAction {

    public ActionNewListener(String name) {
        super(name);
    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
