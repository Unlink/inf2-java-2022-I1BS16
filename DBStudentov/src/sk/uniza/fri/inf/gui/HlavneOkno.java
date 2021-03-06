package sk.uniza.fri.inf.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 3. 5. 2022 - 7:47
 *
 * @author Michal
 */
public class HlavneOkno {
    private final DefaultListModel<Object> zoznamStudentov;

    private JPanel hlavnyPanel;
    private JList studentiList;
    private JButton pridajButton;
    private JButton zmazButton;
    private JButton upravButton;

    public HlavneOkno() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(this.hlavnyPanel);
        jFrame.setTitle("DB studentov");
        jFrame.setLocationRelativeTo(null);
        jFrame.pack();

        JMenuBar menuBar = new JMenuBar();
        JMenu suborMenu = new JMenu("Subor");
        suborMenu.add(new JMenuItem("aaa"));
        menuBar.add(suborMenu);
        jFrame.setJMenuBar(menuBar);

        jFrame.setVisible(true);

        this.zoznamStudentov = new DefaultListModel<>();
        this.zoznamStudentov.addElement(new Student("Janko", "Hrasko", 19));
        this.zoznamStudentov.addElement(new Student("Ferko", "Hrasko", 19));
        this.studentiList.setModel(this.zoznamStudentov);

        this.studentiList.setCellRenderer(new ListCellRenderer<Student>() {
            @Override
            public Component getListCellRendererComponent(JList list, Student value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel();
                label.setText(value.getMeno() + " " + value.getPriezvisko());
                if (isSelected) {
                    label.setForeground(Color.BLUE);
                } else {
                    label.setForeground(Color.BLACK);
                }
                return label;
            }
        });
        zmazButton.addActionListener(e -> {
            List list = studentiList.getSelectedValuesList();
            for (Object o : list) {
                this.zoznamStudentov.removeElement(o);
            }
        });

        pridajButton.addActionListener(e -> {
            StudentEditor dialog = new StudentEditor();
            dialog.pack();
            dialog.setLocationRelativeTo(hlavnyPanel);
            dialog.setVisible(true);
            Student student = dialog.getStudent();
            if (student != null) {
                this.zoznamStudentov.addElement(student);
            }
        });

        upravButton.addActionListener(e -> {
            Student selectedStudent = (Student) studentiList.getSelectedValue();
            if (selectedStudent == null) return;

            StudentEditor dialog = new StudentEditor(selectedStudent);
            dialog.pack();
            dialog.setLocationRelativeTo(hlavnyPanel);
            dialog.setVisible(true);
            Student student = dialog.getStudent();
            if (student != null) {
                this.zoznamStudentov.removeElement(selectedStudent);
                this.zoznamStudentov.addElement(student);
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        hlavnyPanel = new JPanel();
        hlavnyPanel.setLayout(new BorderLayout(0, 0));
        studentiList = new JList();
        studentiList.setMinimumSize(new Dimension(300, 200));
        studentiList.setPreferredSize(new Dimension(300, 200));
        hlavnyPanel.add(studentiList, BorderLayout.CENTER);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        hlavnyPanel.add(panel1, BorderLayout.EAST);
        zmazButton = new JButton();
        zmazButton.setText("Zmaz");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 100.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(zmazButton, gbc);
        pridajButton = new JButton();
        pridajButton.setText("Pridaj");
        pridajButton.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(pridajButton, gbc);
        upravButton = new JButton();
        upravButton.setText("Uprav");
        upravButton.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(upravButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return hlavnyPanel;
    }

}
