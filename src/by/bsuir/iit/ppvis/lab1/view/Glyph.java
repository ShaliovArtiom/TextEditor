package by.bsuir.iit.ppvis.lab1.view;

/**
 * Created by Laptop on 07.03.16.
 */
public class Glyph {
    private char symbol;
    private int size;
    private String font;
    private boolean fatty;
    private boolean italics;

    public Glyph() {}

    public String toString() {
        return "" + symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setFatty(boolean fatty) { this.fatty = fatty; }

    public boolean isFatty() { return fatty; }
}
