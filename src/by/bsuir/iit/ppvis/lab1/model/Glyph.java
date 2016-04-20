package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;

/**
 * Created by Laptop on 07.03.16.
 */
public class Glyph {
    private boolean haveCarriage;
    private boolean selected;
    private char symbol;
    private Font font;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;

    }
    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public boolean isHaveCarriage() {
        return haveCarriage;
    }

    public void setHaveCarriage(boolean haveCarriage) {
        this.haveCarriage = haveCarriage;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
