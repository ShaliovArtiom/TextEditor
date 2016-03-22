package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Laptop on 07.03.16.
 */
public class FileOpenListener extends Component implements ActionListener {
    private JFileChooser chooser;

    public FileOpenListener() {
        chooser = new JFileChooser();
        final ExtensionFileFilter filter = new ExtensionFileFilter();
        filter.addExtension("txt");
        filter.setDescription("Text files");
        chooser.setFileFilter(filter);
    }

    public void actionPerformed(ActionEvent event) {
        chooser.setCurrentDirectory(new File(".."));

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            String name = chooser.getSelectedFile().getPath();
        }
    }
}