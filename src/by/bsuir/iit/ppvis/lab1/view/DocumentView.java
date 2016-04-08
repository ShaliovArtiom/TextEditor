package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Document;
import by.bsuir.iit.ppvis.lab1.model.Glyph;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

class DocumentView extends JPanel {

    private Document document;
    private int x;
    private int y;
    int k = 0;
    private int maxHeight;

    public DocumentView() {
        this.setBackground(Color.WHITE);
        document = new Document();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this));
    }

    public void inputText(char s, Glyph glyph) {
        glyph.setSymbol(s);
        document.addGlyph(glyph);
        repaint();
    }

    public void newLine() {
        k += document.getDefaultFont().getSize();
    }

    public void backSpace() {
        document.deleteLastElement();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        x = 1;
        y = document.getDefaultFont().getSize();
        for (Glyph glyph : document.getGlyphList()) {
            String string = String.valueOf(glyph.getSymbol());
            g2.setFont(glyph.getFont());
            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = glyph.getFont().getStringBounds(string, context);
            double maxY = -bounds.getY();

            if (maxHeight < (int) maxY)
                maxHeight = (int) maxY;

            if (maxHeight > y) {
                g2.drawString(string, x, maxHeight);
            } else {
                g2.drawString(string, x, y);

            }
            //g2.drawString(string, x, y);
            x += g2.getFontMetrics().stringWidth(string);
            if (x > this.getWidth()) {
                this.setPreferredSize(new Dimension(getWidth() + g2.getFontMetrics().stringWidth(string), y));
                this.repaint();
            }
        }
    }


    public Document getDocument() {
        return document;
    }
}

//
//FontRenderContext context = g2.getFontRenderContext();
//Rectangle2D bounds = glyph.getFont().getStringBounds(string, context);
//double maxY = -bounds.getY();
//
//if (maxHeight < (int) maxY)
//        maxHeight = (int) maxY;
//
//        if (maxHeight > y) {
//        g2.drawString(string, x, maxHeight);
//        } else {
//        g2.drawString(string, x, y);
//        y += k;
//        }