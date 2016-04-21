package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Glyph;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class PressKeyListener implements KeyListener {
    private DocumentView documentView;
    private Glyph glyph;

    public PressKeyListener(DocumentView documentView) {
        this.documentView = documentView;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        glyph = new Glyph();


        if (keyChar == KeyEvent.VK_ENTER) {
            documentView.newLine();
        } else if (keyChar == KeyEvent.VK_BACK_SPACE) {
            documentView.backSpace();
        } else
        documentView.inputText(keyChar, glyph);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();

        if(KeyCode == KeyEvent.VK_LEFT) documentView.carriageMoveLeft();
        else if(KeyCode == KeyEvent.VK_RIGHT) documentView.carriageMoveRight();
        else if(KeyCode == KeyEvent.VK_UP) documentView.carriageMoveUp();
        else if(KeyCode == KeyEvent.VK_DOWN) documentView.carriageMoveDown();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}