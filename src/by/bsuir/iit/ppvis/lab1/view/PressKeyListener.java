package by.bsuir.iit.ppvis.lab1.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class PressKeyListener implements KeyListener {
    private Document document;
    private LetterContainer.LettersContainer letterContainer;

    public PressKeyListener(Document document, LetterContainer.LettersContainer letterContainer) {
        this.document = document;
        this.letterContainer = letterContainer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if(keyChar == KeyEvent.VK_ENTER)
        {
            keyChar  = ' ';
            document.newLine(keyChar);
        }
        else if(keyChar == KeyEvent.VK_BACK_SPACE)
        {
            document.backSpace();
        }
        else document.inputText(keyChar);
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}