package by.bsuir.iit.ppvis.lab1.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Laptop on 07.03.16.
 */
public class MyKeyListener extends Frame implements KeyListener, WindowListener {

    private int yHeight;
    private Dimension wndDimension;
    private String s;

    public MyKeyListener(JFrame frame) {
        super();
    }

    public void init() {
        this.addKeyListener(this);
        this.addWindowListener(this);
    }

    private void lineFeed() {
        Graphics g = getGraphics();
        g.setFont(new Font("Courier", Font.PLAIN, 12));

        FontMetrics fm = g.getFontMetrics();
        yHeight = fm.getHeight();

        wndDimension = getSize();
        g.copyArea(0, 1, wndDimension.width - 1, wndDimension.height - yHeight - 5, 0, yHeight + 1);
        g.setColor(Color.BLUE);
        g.fillRect(1, 1, wndDimension.width - 2, yHeight + 1);

    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void showKeyBoardInfo(KeyEvent e) {
        Graphics g = getGraphics();
        g.setFont(new Font("Courier", Font.PLAIN, 12));

        s = "";
        s = e.getKeyText(e.getKeyCode());

        g.drawString(s, 10, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F3) {
            setVisible(false);
            System.exit(0);
        }

        showKeyBoardInfo(e);
        lineFeed();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}