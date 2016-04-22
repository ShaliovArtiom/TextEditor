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
        int counter = 0;
        if (document.getLineList().isEmpty()) {
            document = new Document();
        }
        if (document.getCarriage().getLastGlypgh() != null) {
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
        }

        glyph.setSymbol(s);
        LinkedList<Line> lineList = document.getLineList();
        Line line = lineList.get(lineList.size() - 1);
        while (line.isLineHaveCarriage() != true) {
            counter++;
            line = lineList.get(lineList.size() - counter);
        }
        LinkedList<Glyph> glyphList = line.getGlyphList();
        if (glyphList.indexOf(document.getCarriage().getLastGlypgh()) != -1) {
            line.addGliphIndex(glyph, glyphList.indexOf(document.getCarriage().getLastGlypgh()) + 1);
        } else {
            line.addGliphIndex(glyph, 1);
        }
        line.getGlyphList().getFirst().setHaveCarriage(false);
        document.getCarriage().setLastGlypgh(glyph);
        glyph.setHaveCarriage(true);

        repaint();
    }

    public void newLine() {
        Glyph glyph = new Glyph();
        glyph.setSymbol(' ');
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - 1);
        Line newLine = new Line(line.getFont());
        line.getGlyphList().getFirst().setHaveCarriage(false);
        document.getCarriage().getLastGlypgh().setHaveCarriage(false);
        newLine.addGliphIndex(glyph, 0);
        line.setLineHaveCarriage(false);
        document.newLine(newLine);
        newLine.getGlyphList().getFirst().setHaveCarriage(true);
        newLine.setHeightGlyph(heightGlyph);
        repaint();
    }

    public void carriageMoveLeft() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        if (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) != 0) {
            int positionCarriageHorisontal = glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) - 1;
            glyphLinkedList.get(positionCarriageHorisontal).setHaveCarriage(true);
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.getCarriage().setLastGlypgh(glyphLinkedList.get(positionCarriageHorisontal));
        } else if (line != lineLinkedList.getFirst()) {
            int positionCarriageVertical = lineLinkedList.indexOf(line) - 1;
            line.setLineHaveCarriage(false);
            Line l = lineLinkedList.get(positionCarriageVertical);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.getCarriage().setLastGlypgh(glyphList.getLast());
            glyphList.getLast().setHaveCarriage(true);
            l.setLineHaveCarriage(true);
        }
        repaint();
    }

    public void carriageMoveRight() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);

        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        int positionCarriageHorisontal = glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) + 1;
        if (positionCarriageHorisontal < glyphLinkedList.size()) {
            glyphLinkedList.get(positionCarriageHorisontal).setHaveCarriage(true);
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.getCarriage().setLastGlypgh(glyphLinkedList.get(positionCarriageHorisontal));
        } else if (line != lineLinkedList.getLast()) {
            positionCarriageHorisontal = lineLinkedList.indexOf(line) + 1;
            line.setLineHaveCarriage(false);
            Line l = lineLinkedList.get(positionCarriageHorisontal);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.getCarriage().setLastGlypgh(glyphList.getFirst());
            glyphList.getFirst().setHaveCarriage(true);
            l.setLineHaveCarriage(true);
        }
        repaint();

    }

    public void carriageMoveUp() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);

        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        if (line != lineLinkedList.getFirst()) {
            int positionCarriageVertical = lineLinkedList.indexOf(line) - 1;
            line.setLineHaveCarriage(false);
            Line l = lineLinkedList.get(positionCarriageVertical);

            int positionCarriageHorisontal = glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh());
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            if (positionCarriageHorisontal > glyphList.size() - 1) {
                positionCarriageHorisontal = glyphList.size() - 1;
            }
            glyphList.get(positionCarriageHorisontal).setHaveCarriage(true);
            document.getCarriage().setLastGlypgh(glyphList.get(positionCarriageHorisontal));
            l.setLineHaveCarriage(true);
        }
        repaint();
    }

    public void carriageMoveDown() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);

        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        if (line != lineLinkedList.getLast()) {
            int positionCarriageVertcal = lineLinkedList.indexOf(line) + 1;
            line.setLineHaveCarriage(false);
            Line l = lineLinkedList.get(positionCarriageVertcal);
            int positionCarriageHorisontal = glyphLinkedList.indexOf(document.getCarriage().getLastGlypgh());
            document.getCarriage().getLastGlypgh().setHaveCarriage(false);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            if (positionCarriageHorisontal > glyphList.size() - 1) {
                positionCarriageHorisontal = glyphList.size() - 1;
            }
            glyphList.get(positionCarriageHorisontal).setHaveCarriage(true);
            document.getCarriage().setLastGlypgh(glyphList.get(positionCarriageHorisontal));
            l.setLineHaveCarriage(true);
        }
        repaint();
    }

    public void backSpace() {
        document.getCarriage().getLastGlypgh().setHaveCarriage(false);
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
                line.deleteLastElement();
                lineLinkedList.removeLast();
                if (lineLinkedList.isEmpty()) {
                    document = new Document();
                } else {
                    Line l = document.getLineList().getLast();
                    LinkedList<Glyph> glyphList = l.getGlyphList();
                    document.getCarriage().setLastGlypgh(glyphList.getLast());
                    glyphList.getLast().setHaveCarriage(true);
                    l.setLineHaveCarriage(true);
                }
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