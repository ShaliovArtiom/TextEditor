package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.*;

public class Document extends JPanel {

    private Glyph.LettersContainer letterContainer;

    public Document() {
        this.setBackground(Color.WHITE);
        letterContainer = new Glyph.LettersContainer();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this, letterContainer));
    }

    @Override
    public void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        int x = 1;
        Font textAtributes = new Font("TimesNewRoman", Font.PLAIN, 12);
        g2.setFont(textAtributes);
        int y = g2.getFont().getSize();
        for (Glyph G : letterContainer.list) {
            g2.drawString(G.toString(), x, y);
            x += g2.getFontMetrics().stringWidth(G.toString());
            if (x > this.getWidth() - 5) {
                y += g2.getFont().getSize();
                x = 1;
            }
        }
    }
}
