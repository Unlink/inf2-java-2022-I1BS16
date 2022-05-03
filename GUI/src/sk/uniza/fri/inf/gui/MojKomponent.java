package sk.uniza.fri.inf.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 2. 5. 2022 - 13:20
 *
 * @author Michal
 */
public class MojKomponent extends JComponent {

    public MojKomponent() {
        super();
        setSize(500, 500);
    }


    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(50, 50, 160, 540);
        g.draw3DRect(100, 100, 80, 80, true);
        g.fillOval(60, 60, 50, 100);
        g.drawString("ahoj aaa", 90, 20);
    }
}
