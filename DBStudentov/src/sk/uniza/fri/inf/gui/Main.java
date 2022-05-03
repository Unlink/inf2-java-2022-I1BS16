package sk.uniza.fri.inf.gui;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 3. 5. 2022
 * Time: 7:47
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new HlavneOkno();
    }
}
