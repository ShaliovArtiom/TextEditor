package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Document;
import by.bsuir.iit.ppvis.lab1.model.Glyph;
import by.bsuir.iit.ppvis.lab1.model.Line;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class DocumentView extends JPanel {

    private CarriageView carriageView;
    private Document document;
    private String string;
    private int distanceBetweenGlyph;
    private int heightGlyph;

    public DocumentView() {
        this.setBackground(Color.WHITE);
        document = new Document();
        carriageView = new CarriageView();
        this.addMouseListener(new MouseFocus(this));
        this.addKeyListener(new PressKeyListener(this));
    }

    public void inputText(char s, Glyph glyph) {
        int counter = 0;
        if (document.getLineList().isEmpty()) {
            document = new Document();
            Line line = new Line(document.getDefaultFont());
            Glyph g = new Glyph();
            g.setSymbol(' ');
            line.addGliphIndex(glyph, 0);
            document.newLine(line);
            carriageView.getCarriage().setLastGlypgh(glyph);
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(true);
        }

        glyph.setSymbol(s);
        LinkedList<Line> lineList = document.getLineList();
        Line line = lineList.get(lineList.size() - 1);

        if(lineList.indexOf(lineList.size() - 1) > 0)
        while (line.findCarriage() != true) {
            counter++;
            line = lineList.get(lineList.size() - counter);
        }
        /////////////////////////////////////?????????????????????????????????????????
        LinkedList<Glyph> glyphList = line.getGlyphList();
        if (glyphList.indexOf(carriageView.getCarriage().getLastGlypgh()) != -1) {
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            line.addGliphIndex(glyph, glyphList.indexOf(carriageView.getCarriage().getLastGlypgh()) + 1);
            carriageView.getCarriage().setLastGlypgh(glyph);
            glyph.setHaveCarriage(true);
        } else {
            Line newline = new Line(document.getDefaultFont());
            Glyph g = new Glyph();
            g.setSymbol(' ');
            newline.addGliphIndex(g, 0);
            document.newLine(newline);
            carriageView.getCarriage().setLastGlypgh(g);
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(true);
        }

        repaint();
    }

    public void newLine() {
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - 1);
        if (carriageView.getCarriage().getLastGlypgh() .equals(line.getGlyphList().getLast())) {
            Line newLine = new Line(line.getFont());
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            document.newLine(newLine);
            newLine.setHeightGlyph(heightGlyph);

            Glyph glyph = new Glyph();
            glyph.setSymbol(' ');
            newLine.addGliphIndex(glyph, 0);
            carriageView.getCarriage().setLastGlypgh(glyph);
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(true);
        } else {
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            int x = line.getGlyphList().indexOf(carriageView.getCarriage().getLastGlypgh()) + 1;
            LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
            LinkedList<Glyph> glyphs = new LinkedList<>();
            for (int i = 0; i < glyphLinkedList.size(); i++) {
                if (glyphLinkedList.get(i) .equals(glyphLinkedList.get(x))) {
                    glyphs.add(glyphLinkedList.get(i));
                    x = i + 1;
                }
            }
            for (int i = 0; i < glyphs.size(); i++) {
                glyphLinkedList.removeLast();
            }
            Line newLine = new Line(line.getFont());
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            Glyph glyph = new Glyph();
            glyph.setSymbol(' ');
            newLine.addGliphIndex(glyph, 0);
            for(int i = 0; i < glyphs.size(); i++)
            {
                newLine.addGliphIndex(glyphs.get(i), i + 1);
            }
//            Line newLine = new Line(line.getFont());
//            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
//            newLine.setGlyphList(glyphs);
            document.newLine(newLine);
            glyph.setHaveCarriage(true);
            carriageView.getCarriage().setLastGlypgh(glyph);
            newLine.setHeightGlyph(heightGlyph);
        }
        repaint();
    }

    public void carriageMoveLeft() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        if (glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) != 0) {
            int positionCarriageHorisontal = glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) - 1;
            glyphLinkedList.get(positionCarriageHorisontal).setHaveCarriage(true);
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            carriageView.getCarriage().setLastGlypgh(glyphLinkedList.get(positionCarriageHorisontal));
        } else if (line != lineLinkedList.getFirst()) {
            int positionCarriageVertical = lineLinkedList.indexOf(line) - 1;
            Line l = lineLinkedList.get(positionCarriageVertical);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            carriageView.getCarriage().setLastGlypgh(glyphList.getLast());
            glyphList.getLast().setHaveCarriage(true);
        }
        repaint();
    }

    public void carriageMoveRight() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);

        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        int positionCarriageHorisontal = glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) + 1;
        if (positionCarriageHorisontal < glyphLinkedList.size()) {
            glyphLinkedList.get(positionCarriageHorisontal).setHaveCarriage(true);
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            carriageView.getCarriage().setLastGlypgh(glyphLinkedList.get(positionCarriageHorisontal));
        } else if (line != lineLinkedList.getLast()) {
            positionCarriageHorisontal = lineLinkedList.indexOf(line) + 1;
            Line l = lineLinkedList.get(positionCarriageHorisontal);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            carriageView.getCarriage().setLastGlypgh(glyphList.getFirst());
            glyphList.getFirst().setHaveCarriage(true);
        }
        repaint();

    }

    public void carriageMoveUp() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);

        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        if (line != lineLinkedList.getFirst()) {
            int positionCarriageVertical = lineLinkedList.indexOf(line) - 1;
            Line l = lineLinkedList.get(positionCarriageVertical);

            int positionCarriageHorisontal = glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh());
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            if (positionCarriageHorisontal > glyphList.size() - 1) {
                positionCarriageHorisontal = glyphList.size() - 1;
            }
            glyphList.get(positionCarriageHorisontal).setHaveCarriage(true);
            carriageView.getCarriage().setLastGlypgh(glyphList.get(positionCarriageHorisontal));
        }
        repaint();
    }

    public void carriageMoveDown() {
        int counter = 1;
        LinkedList<Line> lineLinkedList = document.getLineList();
        Line line = lineLinkedList.get(lineLinkedList.size() - counter);

        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        while (glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh()) == -1) {
            counter++;
            line = lineLinkedList.get(lineLinkedList.size() - counter);
            glyphLinkedList = line.getGlyphList();
        }
        if (line != lineLinkedList.getLast()) {
            int positionCarriageVertcal = lineLinkedList.indexOf(line) + 1;
            Line l = lineLinkedList.get(positionCarriageVertcal);
            int positionCarriageHorisontal = glyphLinkedList.indexOf(carriageView.getCarriage().getLastGlypgh());
            carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
            LinkedList<Glyph> glyphList = l.getGlyphList();
            if (positionCarriageHorisontal > glyphList.size() - 1) {
                positionCarriageHorisontal = glyphList.size() - 1;
            }
            glyphList.get(positionCarriageHorisontal).setHaveCarriage(true);
            carriageView.getCarriage().setLastGlypgh(glyphList.get(positionCarriageHorisontal));
        }
        repaint();
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
            int x = line.getGlyphList().indexOf(carriageView.getCarriage().getLastGlypgh()) - 1;
            if (x >= 0) {
                line.getGlyphList().get(x).setHaveCarriage(true);
                line.deleteGliphIndex(line.getGlyphList().indexOf(carriageView.getCarriage().getLastGlypgh())); //////////
                    carriageView.getCarriage().setLastGlypgh(line.getGlyphList().get(x));
                    //   line.getGlyphList().get(line.getGlyphList().size() - 1).setHaveCarriage(true);
                }
//            else {
//                carriageView.getCarriage().setLastGlypgh(null);
//            }
                if (carriageView.getCarriage().getLastGlypgh() .equals(line.getGlyphList().getFirst())) {
                    line.deleteLastElement();
                    lineLinkedList.removeLast();
                    if (lineLinkedList.isEmpty()) {
                        document = new Document();
                    } else {
                        Line l = document.getLineList().getLast();
                        LinkedList<Glyph> glyphList = l.getGlyphList();
                        System.out.print("a");
                        carriageView.getCarriage().setLastGlypgh(glyphList.getLast());
                        glyphList.getLast().setHaveCarriage(true);
                    }
                }

                repaint();
            }
        }

    public void carriageMoveMouse(int x, int y)
    {
        LinkedList<Line> lineLinkedList = document.getLineList();
        LinkedList<Glyph> glyphLinkedList = new LinkedList<>();
        for (Line line : lineLinkedList) {
            if (y <= line.getHeightGlyph() && y >= line.getHeightGlyph() - line.getMaxHeightOfElement()) {
                glyphLinkedList = line.getGlyphList();
            }
        }
        for (Glyph glyph : glyphLinkedList) {
            if(x >= glyph.getX() && x <= glyph.getX() + glyph.getWhight() && y <= glyph.getY() + glyph.getHight() && y <= glyph.getY())
            {
                carriageView.getCarriage().getLastGlypgh().setHaveCarriage(false);
                carriageView.getCarriage().setLastGlypgh(glyph);
                glyph.setHaveCarriage(true);
            }
        }
        repaint();
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
        LinkedList<Glyph> glyphLinkedList = line.getGlyphList();
        for (Glyph glyph : glyphLinkedList) {
            string = String.valueOf(glyph.getSymbol());
            g2.setFont(glyph.getFont());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            glyph.setWhight(g2.getFontMetrics().stringWidth(string));
            glyph.setHight(line.getMaxHeightOfElement());
            glyph.setX(distanceBetweenGlyph);
            glyph.setY(heightGlyph);
            carriageView.drawCarriage(g2, glyph, glyph.getX(), glyph.getY());
            g2.drawString(string, glyph.getX(), glyph.getY());

            distanceBetweenGlyph += g2.getFontMetrics().stringWidth(string);
        }
    }


    @Override
    protected void paintComponent(Graphics gr) {
        gr.clearRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2 = (Graphics2D) gr;
        distanceBetweenGlyph = 1;
        for (Line line : document.getLineList()) {
            heightGlyph = line.getHeightGlyph();
            drawGliph(g2, line);
            moveScrollPane(g2);
        }
    }

    public Document getDocument() {
        return document;
    }
}