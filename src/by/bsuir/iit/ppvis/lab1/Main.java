package by.bsuir.iit.ppvis.lab1;

import by.bsuir.iit.ppvis.lab1.menu.MenuFrame;

import javax.swing.*;

/**
 * Created by Shaliov.Artiom on 17.02.2016.
 */
public class Main {
    public static void main(String[] argc) {
        JFrame frame = new JFrame();
        new MenuFrame(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

