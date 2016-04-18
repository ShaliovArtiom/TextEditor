package by.bsuir.iit.ppvis.lab1.view;

import by.bsuir.iit.ppvis.lab1.model.Carriage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseFocus implements MouseListener {
    private DocumentView documentView;
    private Carriage carriage;

    public MouseFocus(DocumentView documentView) {
        this.documentView = documentView;
        carriage = new Carriage();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        documentView.requestFocusInWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
