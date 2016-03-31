package by.bsuir.iit.ppvis.lab1.view;

import java.awt.*;

/**
 * Created by Laptop on 07.03.16.
 */
public class Glyph {
    private char symbol;
    private Font textAtributes;

    public Glyph() {}

    public String toString() {
        return "" + symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTextAtributes(Font textAtributes) {
        this.textAtributes = textAtributes;
    }

    public Font getTextAtributes() {
        return textAtributes;
    }
}
