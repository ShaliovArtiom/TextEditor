package by.bsuir.iit.ppvis.lab1.view;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseFocus implements MouseListener {
    private JPanel document;

    public MouseFocus(JPanel document) {
        this.document = document;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        document.requestFocusInWindow();
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
