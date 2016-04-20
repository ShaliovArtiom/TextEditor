package by.bsuir.iit.ppvis.lab1.model;

import java.awt.*;

/**
 * Created by TyZiK on 04.04.2016.
 */
public class Carriage {
    private char carriage;
    private Glyph lastGlypgh;
    private boolean visibleCarriage;
    private Font font;

    public Carriage() {
        font = new Font("TimesNewRoman" , 0 ,10);
        carriage = '_';
        lastGlypgh = null;
    }

    public Glyph getLastGlypgh() {
        return lastGlypgh;
    }

    public void setLastGlypgh(Glyph lastGlypgh) {
        this.lastGlypgh = lastGlypgh;
    }

    public char getCarriage() {
        return carriage;
    }

    public void setCarriage(char carriage) {
        this.carriage = carriage;
    }

    public boolean isVisibleCarriage() {
        return visibleCarriage;
    }

    public void setVisibleCarriage(boolean visibleCarriage) {
        this.visibleCarriage = visibleCarriage;
    }
}
