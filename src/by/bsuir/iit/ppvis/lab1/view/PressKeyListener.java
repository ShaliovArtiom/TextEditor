package by.bsuir.iit.ppvis.lab1.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class PressKeyListener implements KeyListener {
    private Document document;
    private Glyph.LettersContainer lettersContainer;

    public PressKeyListener(Document document, Glyph.LettersContainer lettersContainer) {
        this.document = document;
        this.lettersContainer = lettersContainer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Glyph glyph = new Glyph();
        glyph.setSymbol(e.getKeyChar());
        lettersContainer.addLetter(glyph);
        document.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}