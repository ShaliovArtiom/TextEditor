package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by TyZiK on 08.04.2016.
 */
public class Line {
    private int heightGlyph;
    private int maxHeightOfElement;
    private LinkedList<Glyph> glyphList;
    private Font font;


    public Line(Font font) {
        heightGlyph = 0;
        maxHeightOfElement = 0;
        glyphList = new LinkedList<>();
        this.font = font;
    }

//    public void addGlyph(Glyph glyph) {
//        Font currientfont = new Font(font.getName(), font.getStyle(),font.getSize());
//        glyph.setFont(currientfont);
//        if (maxHeightOfElement < currientfont.getSize()) {
//            maxHeightOfElement = currientfont.getSize();
//        }
//        glyphList.add(glyph);
//    }

    public void addGliphIndex(Glyph glyph, int index) {
        Font currientfont = new Font(font.getName(), font.getStyle(), font.getSize());
        glyph.setFont(currientfont);
        if (maxHeightOfElement < currientfont.getSize()) {
            maxHeightOfElement = currientfont.getSize();
        }
        glyphList.add(index, glyph);

    }

    public boolean findCarriage() {
        for (Glyph glyph : glyphList) {
            if (glyph.isHaveCarriage()) {
                return true;
            }
        }
        return false;
    }

    public void deleteGliphIndex(int index) {
        glyphList.remove(index);
    }

    public void deleteLastElement() {
        if (!glyphList.isEmpty()) {
            glyphList.removeLast();
        }
    }

    public LinkedList<Glyph> getGlyphList() {
        return glyphList;
    }

    public void setGlyphList(LinkedList<Glyph> glyphList) {
        this.glyphList = glyphList;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getMaxHeightOfElement() {
        return maxHeightOfElement;
    }

    public void setMaxHeightOfElement(int maxHeightOfElement) {
        this.maxHeightOfElement = maxHeightOfElement;
    }

    public int getHeightGlyph() {
        return heightGlyph + maxHeightOfElement;
    }

    public void setHeightGlyph(int heightGlyph) {
        this.heightGlyph = heightGlyph;
    }
}
