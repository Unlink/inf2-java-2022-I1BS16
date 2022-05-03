package sk.uniza.fri.inf.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 2. 5. 2022
 * Time: 13:20
 */
public class Main {

    public static void main(String[] args) {
        JFrame okno = new JFrame();
        okno.setTitle("Moje prve okno");
        okno.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JLabel jLabelText = new JLabel();
        jLabelText.setText("Zadaj meno");
        //jLabelText.setHorizontalAlignment(SwingConstants.CENTER);
        //jLabelText.setFont(jLabelText.getFont().deriveFont(25f));
        topPanel.add(jLabelText, BorderLayout.LINE_START);
        JTextField meno = new JTextField();
        topPanel.add(meno, BorderLayout.CENTER);
        JButton jButton = new JButton();
        jButton.setText("Pozdrav");
        topPanel.add(jButton, BorderLayout.LINE_END);

        //JLabel jLabelText2 = new JLabel();
        //jLabelText2.setText("Ahoj java");
        //okno.getContentPane().add(jLabelText2);

        okno.add(topPanel, BorderLayout.NORTH);

        JPanel vtipneTlacidloPanel = new JPanel();
        vtipneTlacidloPanel.setLayout(null);

        JButton vtipneTlacidlo = new JButton();
        vtipneTlacidlo.setText("zatvor okno");
        vtipneTlacidlo.setBounds(100, 20, 100, 20);
        vtipneTlacidlo.addActionListener(e -> System.exit(0));
        Random random = new Random();
        vtipneTlacidlo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                vtipneTlacidlo.setBounds(random.nextInt(vtipneTlacidloPanel.getWidth() - 100), random.nextInt(vtipneTlacidloPanel.getHeight() - 20), 100, 20);
            }
        });

        vtipneTlacidloPanel.add(vtipneTlacidlo);

        //okno.add(vtipneTlacidloPanel, BorderLayout.CENTER);
        okno.add(new MojKomponent(), BorderLayout.CENTER);


        //okno.setUndecorated(true);
        okno.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int vysledok = JOptionPane.showConfirmDialog(okno, "Skutocne zatvorit okno?");
                if (vysledok == JOptionPane.YES_OPTION) {
                    okno.dispose();
                }
            }
        });


        okno.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        okno.setSize(600, 200);
        //okno.setResizable(false);
        okno.setVisible(true);
    }
}
