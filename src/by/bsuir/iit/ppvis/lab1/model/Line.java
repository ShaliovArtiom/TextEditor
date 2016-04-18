package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TyZiK on 08.04.2016.
 */
public class Line {
    private String string;
    private int heightGlyph;
    private int maxHeightOfElement;
    private List<Glyph> glyphList;
    private Font font;


    public Line(Font font) {
        heightGlyph = 0;
        maxHeightOfElement = 0;
        glyphList = new ArrayList<>();
        this.font = font;
    }

    public void addGlyph(Glyph glyph) {
        Font currientfont = new Font(font.getName(), font.getStyle(),font.getSize());
        glyph.setFont(currientfont);
        if (maxHeightOfElement < currientfont.getSize()) {
            maxHeightOfElement = currientfont.getSize();
        }
        glyphList.add(glyph);
        string = String.valueOf(glyph.getSymbol());
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

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getMaxHeightOfElement() {
        return maxHeightOfElement + heightGlyph;
    }

    public void setMaxHeightOfElement(int maxHeightOfElement) {
        this.maxHeightOfElement = maxHeightOfElement;
    }

    public int getHeightGlyph() {
        return heightGlyph;
    }

    public void setHeightGlyph(int heightGlyph) {
        this.heightGlyph = heightGlyph;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
