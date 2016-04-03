package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TyZiK on 03.04.2016.
 */
public class Document {
    private List<Glyph> glyphList = new ArrayList<>();
    private Font defaultFont;

    public void addLetter(Glyph glyph) {
        glyphList.add(glyph);
    }

    public void deleteLastElement() {
        if (!glyphList.isEmpty()) {
            glyphList.remove(glyphList.size() - 1);
        }

    }

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

