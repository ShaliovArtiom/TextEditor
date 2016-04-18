package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TyZiK on 03.04.2016.
 */
public class Document {

    private List<Line> lineList;
    private Font defaultFont;
    private Carriage carriage;

    public Document() {
        defaultFont = new Font("TimesNewRoman", 0, 10);
        lineList = new ArrayList<>();
        lineList.add(new Line(defaultFont));
    }

    public void newLine(Line line) {
        lineList.add(line);
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public Font getDefaultFont() {
        return defaultFont;
    }

    public void setDefaultFont(Font defaultFont) {
        this.defaultFont = defaultFont;
    }
}

