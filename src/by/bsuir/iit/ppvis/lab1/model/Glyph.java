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
    private int x;
    private int y;
    private int whight;
    private int hight;

    public Glyph() {
        x = 1;
        y = 1;
    }

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWhight() {
        return whight;
    }

    public void setWhight(int whight) {
        this.whight = whight;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
}
