package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Laptop on 03.03.16.
 */
public class ExtensionFileFilter extends FileFilter {

    public void addExtension(String extension) {
        if (!extension.startsWith("."))
            extension = "." + extension;
        extensions.add(extension.toLowerCase());

    }

    public void setDescription(String aDescription) {
        description = aDescription;

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        String name = f.getName().toLowerCase();
        for (String extension : extensions)
            if (name.endsWith(extension))
                return true;
        return false;
    }

    private String description = "";
    private ArrayList<String> extensions = new ArrayList<String>();
}

