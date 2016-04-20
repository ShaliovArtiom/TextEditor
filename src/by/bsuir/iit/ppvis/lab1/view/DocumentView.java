package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Document;
import by.bsuir.iit.ppvis.lab1.model.Glyph;
import by.bsuir.iit.ppvis.lab1.model.Line;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class DocumentView extends JPanel {

    private Document document;
    private String string;
    private String carriage;
    private int distanceBetweenGlyph;
    private int heightGlyph;

    public DocumentView() {
        this.setBackground(Color.WHITE);
        document = new Document();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this));
    }

    public void inputText(char s, Glyph glyph) {
        if (document.getLineList().isEmpty()) {
            document = new Document();
        }
        if (document.getCarriage().getLastGlypgh() != null)
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
        glyph.setSymbol(s);
        LinkedList<Line> lineList = document.getLineList();
        Line line = lineList.get(lineList.size() - 1);
        line.addGlyph(glyph);
        document.getCarriage().setLastGlypgh(glyph);
        glyph.setHaveCarriage(true);
        repaint();
    }

    public void newLine() {
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - 1);
        Line newLine = new Line(line.getFont());
        document.newLine(newLine);
        newLine.setHeightGlyph(heightGlyph);

    }

    public void carriageMoveLeft() {
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - 1);
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        if (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) != 0) {
            int x = glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) - 1;
            glyphLinkedList.get(x).setHaveCarriage(true);
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.getCarriage().setLastGlypgh(glyphLinkedList.get(x));
        }
        repaint();

    }

    public void carriageMoveRight() {
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - 1);
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        if (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) != 0) {
            int x = glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) + 1;
            glyphLinkedList.get(x).setHaveCarriage(true);
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.getCarriage().setLastGlypgh(glyphLinkedList.get(x));
        }
        repaint();

    }

    public void carriageMoveUp() {
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - 1);
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();

    }

    public void backSpace() {
        int maxHeightGlyphBakcspace = 0;
        if (!document.getLineList().isEmpty()) {
            LinkedList<Line> lineLinkedList = document.getLineList();
            Line line = lineLinkedList.get(lineLinkedList.size() - 1);
            for (Glyph g : line.getGlyphList()) {
                if (maxHeightGlyphBakcspace < g.getFont().getSize()) {
                    maxHeightGlyphBakcspace = g.getFont().getSize();
                }
                line.setMaxHeightOfElement(maxHeightGlyphBakcspace);
            }
            line.deleteLastElement();
            if (line.getGlyphList().isEmpty()) {
                document.getCarriage().setLastGlypgh(null);
            } else {
                document.getCarriage().setLastGlypgh(line.getGlyphList().get(line.getGlyphList().size() - 1));
                line.getGlyphList().get(line.getGlyphList().size() - 1).setHaveCarriage(true);
            }

            if (line.getGlyphList().isEmpty()) {
                lineLinkedList.removeLast();
                int x = lineLinkedList.size() - 1;
                Line l = lineLinkedList.get(x);
                LinkedList<Glyph> glyphList = l.getGlyphList();
                glyphList.get(glyphList.size()).setHaveCarriage(true);
                document.getCarriage().setLastGlypgh(glyphList.get(glyphList.size()));
            }
            repaint();
        }
    }


    private void moveScrollPane(Graphics2D g2) {
        if (distanceBetweenGlyph > this.getWidth()) {
            this.setPreferredSize(new Dimension(getWidth() +
                    g2.getFontMetrics().stringWidth(string), heightGlyph));
        } else if (heightGlyph > this.getHeight()) {
            this.setPreferredSize(new Dimension(getHeight() +
                    distanceBetweenGlyph, heightGlyph));
        }
        distanceBetweenGlyph = 1;
    }


    private void drawGliph(Graphics2D g2, Line line) {
        carriage = String.valueOf(document.getCarriage().getCarriage());
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        if (document.getCarriage().getLastGlypgh() == null) {
            g2.drawString(carriage, 1, 10);
        }

        for (Glyph glyph : glyphLinkedList) {
            string = String.valueOf(glyph.getSymbol());
            drawCarriage(g2, glyph);
            g2.setFont(glyph.getFont());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawString(string, distanceBetweenGlyph, heightGlyph);
            distanceBetweenGlyph += g2.getFontMetrics().stringWidth(string);

        }
    }

    private void drawCarriage(Graphics2D g2, Glyph glyph) {

        if (glyph.isHaveCarriage()) {
            g2.drawString(carriage, distanceBetweenGlyph + glyph.getFont().getSize() / 3, heightGlyph + 1);
        }
    }

    @Override
    protected void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        distanceBetweenGlyph = 1;
        for (Line line : document.getLineList()) {
            heightGlyph = line.getMaxHeightOfElement();
            drawGliph(g2, line);
            moveScrollPane(g2);
        }
    }

    public Document getDocument() {
        return document;
    }
}