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
   // private boolean lineHaveCarriage;


    public Line(Font font) {
       // lineHaveCarriage = true;
        heightGlyph = 0;
        maxHeightOfElement = 0;
        glyphList = new LinkedList<>();
        this.font = font;

    }

    public void addGlyph(Glyph glyph) {
        Font currientfont = new Font(font.getName(), font.getStyle(),font.getSize());
        glyph.setFont(currientfont);
        if (maxHeightOfElement < currientfont.getSize()) {
            maxHeightOfElement = currientfont.getSize();
        }
        glyphList.add(glyph);
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

//    public boolean isLineHaveCarriage() {
//        return lineHaveCarriage;
//    }
//
//    public void setLineHaveCarriage(boolean lineHaveCarriage) {
//        this.lineHaveCarriage = lineHaveCarriage;
//    }
}
