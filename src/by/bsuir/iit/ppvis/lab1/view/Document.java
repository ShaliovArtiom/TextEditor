package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.*;

public class Document extends JPanel {

    private LetterContainer.LettersContainer letterContainer;
    private int x;
    private int y;
    private Font textAtributes;
    private boolean b;

    public Document() {
        this.setBackground(Color.WHITE);
        letterContainer = new LetterContainer.LettersContainer();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this, letterContainer));
    }

    public void inputText(char s) {
        Glyph glyph = new Glyph();
        glyph.setSymbol(s);
        letterContainer.addLetter(glyph);
        repaint();
    }

    public void newLine(char s) {
        Glyph glyph = new Glyph();
        glyph.setSymbol(s);
        while (x < this.getWidth() - 6) {
            letterContainer.addLetter(glyph);
            x += 3;
            this.repaint();
        }
    }

    public void backSpace() {
        letterContainer.deleteLastElement();
        this.repaint();
    }

    public void fatty() {
        Glyph g = new Glyph();
        if (!g.isFatty()) {
            g.setFatty(true);
        } else {
            g.setFatty(false);
        }
        System.out.print(g.isFatty());
        //return textAtributes;
    }

    @Override
    public void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        x = 1;
        textAtributes = new Font("Area", Font.PLAIN, 12);
        g2.setFont(textAtributes);
        y = g2.getFont().getSize();
        for (Glyph G : letterContainer.list) {
            g2.drawString(G.toString(), x, y);
            x += g2.getFontMetrics().stringWidth(G.toString());
            if (x > this.getWidth() - 7) {
                y += g2.getFont().getSize();
                x = 1;
            }
        }
    }
}
