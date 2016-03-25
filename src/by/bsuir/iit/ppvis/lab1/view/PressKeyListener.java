package by.bsuir.iit.ppvis.lab1.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class PressKeyListener implements KeyListener {
    private Document document;
    private LetterContainer.LettersContainer lettersContainer;

    public PressKeyListener(Document document, LetterContainer.LettersContainer lettersContainer) {
        this.document = document;
        this.lettersContainer = lettersContainer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        document.inputText(e);
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}