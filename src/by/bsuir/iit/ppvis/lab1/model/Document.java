package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by TyZiK on 03.04.2016.
 */
public class Document {

   // private Carriage carriage;
    private LinkedList<Line> lineList;
    private Font defaultFont;

    public Document() {
        //carriage = new Carriage();
        defaultFont = new Font("TimesNewRoman", 0, 10);
        lineList = new LinkedList<>();
        Line line = new Line(defaultFont);
        lineList.add(line);
    }

    public void newLine(Line line) {
        lineList.add(line);
    }

    public LinkedList<Line> getLineList() {
        return lineList;
    }

    public void setLineList(LinkedList<Line> lineList) {
        this.lineList = lineList;
    }

    public Font getDefaultFont() {
        return defaultFont;
    }

    public void setDefaultFont(Font defaultFont) {
        this.defaultFont = defaultFont;
    }

}

