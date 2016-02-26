import Menu.MenuFrame;

import javax.swing.*;

/**
 * Created by TyZiK on 17.02.2016.
 */
public class Main {
    public static void main(String[] argc)
    {
        JFrame frame = new JFrame();
        new MenuFrame(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}

