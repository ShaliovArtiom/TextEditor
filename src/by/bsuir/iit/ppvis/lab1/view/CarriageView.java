package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Carriage;
import by.bsuir.iit.ppvis.lab1.model.Glyph;

import java.awt.*;

class CarriageView {
    private String stringCarriage;
    private Carriage carriage;
    private int y;

    public CarriageView() {
        carriage = new Carriage();
    }


    public void drawCarriage(Graphics2D g2, Glyph glyph, int x, int y) {
        stringCarriage = String.valueOf(carriage.getCarriage());
        if (glyph.isHaveCarriage()) {
            carriage.setFont(glyph.getFont());
            g2.setFont(carriage.getFont());
            g2.drawString(stringCarriage, x + 2, y);
        }
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }
}
