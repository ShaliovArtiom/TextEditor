package by.bsuir.iit.ppvis.lab1.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class PressKeyListener implements KeyListener {
    private Document document;
    private Glyph glyph;
    ToolBarCreater toolBarCreater;

    public PressKeyListener(Document document) {
        this.document = document;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        glyph = new Glyph();
        if(keyChar == KeyEvent.VK_ENTER)
        {
            keyChar  = ' ';
            document.newLine(keyChar, glyph);
        }
        else if(keyChar == KeyEvent.VK_BACK_SPACE)
        {
            document.backSpace();
        }
        else document.inputText(keyChar, glyph);
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}