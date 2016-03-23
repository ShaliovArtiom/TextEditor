package by.bsuir.iit.ppvis.lab1.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laptop on 07.03.16.
 */
public class Glyph {
    private char symbol;
    private int size;
    private String font;
    private boolean fatty;
    private boolean italics;

    public Glyph() {
        fatty = false;
        italics = false;
        size = 12;
        font = "TimesNewRoman";
    }

    public String toString() {
        return "" + symbol;
    }

    public static class LettersContainer {
        public List<Glyph> list = new ArrayList<>();

        public void addLetter(Glyph glyph) {
            list.add(glyph);
        }
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
