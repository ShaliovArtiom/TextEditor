package by.bsuir.iit.ppvis.lab1.model;

import java.util.List;

/**
 * Created by TyZiK on 08.04.2016.
 */
public class Line {
    private int lineNumber;
    private List<Glyph> list;

    public List<Glyph> getList() {
        return list;
    }

    public void setList(List<Glyph> list) {
        this.list = list;
    }


    public int getLineNumber() {
        return list.indexOf(lineNumber);
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
