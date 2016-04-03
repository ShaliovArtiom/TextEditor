package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Document;
import by.bsuir.iit.ppvis.lab1.model.Glyph;

import javax.swing.*;
import java.awt.*;

/**
 * Created by TyZiK on 03.04.2016.
 */
class DocumentView extends JPanel {

    private Document document;
    private int x;
    private int y;

    public DocumentView() {
        this.setBackground(Color.WHITE);
        document = new Document();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this));
    }

    public void inputText(char s, Glyph glyph) {
        glyph.setSymbol(s);
        document.addLetter(glyph);
        repaint();
    }

    public void newLine(char s, Glyph glyph) {
        glyph.setSymbol(s);
        while (x < this.getWidth() - 6) {
            document.addLetter(glyph);
            x += glyph.getFont().getSize() / 4; // делить size на 4
            this.repaint();
        }
    }

    public void backSpace() {
        document.deleteLastElement();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        x = 1;
        for (Glyph glyph : document.getGlyphList()) {
            String string = String.valueOf(glyph.getSymbol());
            y = glyph.getFont().getSize();
            g2.setFont(glyph.getFont());
            g2.drawString(string, x, y);
            x += g2.getFontMetrics().stringWidth(string);
            if (x > this.getWidth() - 7) {
                y += g2.getFont().getSize();
                x = 1;
            }
        }
    }


    public Document getDocument() {
        return document;
    }
}
