package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Document;
import by.bsuir.iit.ppvis.lab1.model.Glyph;
import by.bsuir.iit.ppvis.lab1.model.Line;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class DocumentView extends JPanel {

    private Document document;
    private String string;
    private int distanceBetweenGlyph;
    private int heightGlyph;

    public DocumentView() {
        this.setBackground(Color.WHITE);
        document = new Document();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this));
    }

    public void inputText(char s, Glyph glyph) {
        glyph.setSymbol(s);
        List<Line> lineList = document.getLineList();
        Line line = lineList.get(lineList.size() - 1);
        line.addGlyph(glyph);
        repaint();
    }

    public void newLine() {
        Line line = new Line(document.getDefaultFont());
        document.newLine(line);
        line.setHeightGlyph(heightGlyph);
    }

    public void backSpace() {
        List<Line> lineList = document.getLineList();
        Line line = lineList.get(lineList.size() - 1);
        line.deleteLastElement();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        distanceBetweenGlyph = 1;
        for (Line line : document.getLineList()) {
            heightGlyph = line.getMaxHeightOfElement() + document.getLineList().indexOf(line);

            List<Glyph> glyphList = line.getGlyphList();
            for (Glyph glyph : glyphList) {
                string = String.valueOf(glyph.getSymbol());
                g2.setFont(glyph.getFont());

                g2.drawString(string, glyphList.indexOf(glyph) + distanceBetweenGlyph, heightGlyph);
                distanceBetweenGlyph += g2.getFontMetrics().stringWidth(string);

            }
            distanceBetweenGlyph = 1;
            if (distanceBetweenGlyph > this.getWidth()) {
                this.setPreferredSize(new Dimension(getWidth() +
                        g2.getFontMetrics().stringWidth(string), document.getLineList().indexOf(line)));
            } //else if (document.getLineList().indexOf(line) > this.getHeight()) {
//                this.setPreferredSize(new Dimension(getHeight() +
//                        document.getDefaultFont().getSize(), document.getLineList().indexOf(line)));
//            }
        }
    }

    public Document getDocument() {
        return document;
    }
}