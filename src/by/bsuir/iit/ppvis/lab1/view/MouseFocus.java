package by.bsuir.iit.ppvis.lab1.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseFocus implements MouseListener {
    private DocumentView documentView;
    private int x;
    private int y;

    public MouseFocus(DocumentView documentView) {
        this.documentView = documentView;
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
        x = e.getX();
        y = e.getY();
        documentView.carriageMoveMouse(x, y);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
