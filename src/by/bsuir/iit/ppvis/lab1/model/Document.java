package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TyZiK on 03.04.2016.
 */
public class Document {
    private List<Glyph> glyphList;
    //    private Line listLine;
    private Font defaultFont;

    public Document() {
//        listLine = new Line();
//        listLine.setList(new ArrayList<>());
//        listLine.setLineNumber(0);
        glyphList = new ArrayList<>();
        defaultFont = new Font("TimesNewRoman", 0, 10);
    }

    public void addGlyph(Glyph glyph) {
        if (defaultFont.getSize() == 10 & defaultFont.getName() == "TimesNewRoman" & defaultFont.getStyle() == 0) {
            glyph.setFont(defaultFont);
        } else {
            Font font = new Font(defaultFont.getName(), defaultFont.getStyle(), defaultFont.getSize());
            glyph.setFont(font);
        }
        glyphList.add(glyph);

    }

    public void deleteLastElement() {
        if (!glyphList.isEmpty()) {
            glyphList.remove(glyphList.size() - 1);
        }
    }

//    public void newLine() {
//        listLine.setList(glyphList);
//        listLine.setLineNumber(+1);
//    }


    public List<Glyph> getGlyphList() {
        return glyphList;
    }

    public void setGlyphList(List<Glyph> glyphList) {
        this.glyphList = glyphList;
    }

    public Font getDefaultFont() {
        return defaultFont;
    }

    public void setDefaultFont(Font defaultFont) {
        this.defaultFont = defaultFont;
    }
}

