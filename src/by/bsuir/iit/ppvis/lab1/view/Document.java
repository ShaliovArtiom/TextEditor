package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.*;

public class Document extends JPanel {

    private LetterContainer.LettersContainer letterContainer;
    private int x;
    private int y;
    private Font textAtributes;

    public Document() {
        this.setBackground(Color.WHITE);
        letterContainer = new LetterContainer.LettersContainer();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this));
    }

    public void inputText(char s, Glyph glyph) {
        glyph.setSymbol(s);
        textAtributes = glyph.getTextAtributes();
        letterContainer.addLetter(glyph);
        repaint();
    }

    public void newLine(char s, Glyph glyph) {
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

//    public void fatty() {
//        glyph = new Glyph();
//        if (glyph.getFatty() == 0) {
//            glyph.setFatty(1);
//            textAtributes = new Font("Aria", glyph.getFatty(), 12);
//        } else {
//            glyph.setFatty(0);
//            textAtributes = new Font("Aria", glyph.getFatty(), 12);
//        }
//        System.out.print(glyph.getFatty());
//        //return textAtributes;
//    }

    @Override
    public void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        x = 1;
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
