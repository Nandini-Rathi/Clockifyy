package Clockify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;

class CLOCKIFY {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1000, 500);
        frame.setTitle("Clockify");

        JTextField t1, t2;
        JButton button;
        t1 = new JTextField();
        t2 = new JTextField();

        button = new JButton("Enter");
        t1.setBounds(420, 250, 180, 30);
        t2.setBounds(420, 290, 180, 30);
        button.setBounds(460, 340, 80, 20);
        frame.getContentPane().add(t1);
        frame.getContentPane().add(t2);
        frame.getContentPane().add(button);
        Container c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.gray);
        ImageIcon icon = new ImageIcon("clockify.png");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);

        JLabel label = new JLabel("Date");
        label.setBounds(300, 250, 100, 30);
        JLabel label2 = new JLabel("Time");
        label2.setBounds(300, 290, 100, 30);
        JLabel label3 = new JLabel(icon);
        label3.setBounds(100, 100, 50, 50);
        JLabel label4 = new JLabel("CLOCKIFY");
        label4.setBounds(475, 7, 175, 100);
        c.add(label);
        c.add(label2);
        c.add(label3);
        c.add(label4);

        JFrame frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setBounds(100, 100, 1000, 500);
        Container c2 = frame2.getContentPane();
        c2.setLayout(null);
        c2.setBackground(Color.WHITE);
        frame2.setTitle("Settings");

        JLabel label6 = new JLabel("Task:");
        frame2.getContentPane().add(label6);
        label6.setBounds(280, 200, 200, 200);
        JLabel label7 = new JLabel("START_TIME:");
        frame2.getContentPane().add(label7);
        label7.setBounds(280, 240, 200, 200);
        JLabel label8 = new JLabel("END_TIME");
        frame2.getContentPane().add(label8);
        label8.setBounds(280, 280, 200, 200);
        JButton button2, button3, button4, button5;

        button2 = new JButton("Add");
        button3 = new JButton("Update");
        button4 = new JButton("Delete");
        button5 = new JButton("Back");

        button2.setBounds(610, 285, 180, 20);
        button2.setBackground(Color.RED);
        button2.setForeground(Color.black);
        button2.setFont(new Font("Times New Roman", Font.BOLD, 15));

        button3.setBounds(610, 325, 180, 20);
        button3.setBackground(Color.YELLOW);
        button3.setForeground(Color.black);
        button3.setFont(new Font("Times New Roman", Font.BOLD, 15));

        button4.setBounds(610, 375, 180, 20);
        button4.setBackground(Color.PINK);
        button4.setForeground(Color.black);
        button4.setFont(new Font("Times New Roman", Font.BOLD, 15));

        button5.setBounds(420, 415, 180, 20);
        button5.setBackground(Color.GREEN);
        button5.setForeground(Color.black);
        button5.setFont(new Font("Times New Roman", Font.BOLD, 15));

        frame2.getContentPane().add(button2);
        frame2.getContentPane().add(button3);
        frame2.getContentPane().add(button4);
        frame2.getContentPane().add(button5);

        JTextField t3, t4, t5;
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();

        t3.setBounds(420, 280, 180, 30);
        t4.setBounds(420, 320, 180, 30);
        t5.setBounds(420, 370, 180, 30);

        JLabel label11 = new JLabel("TASK");
        frame2.getContentPane().add(label11);
        label11.setBounds(330, 04, 200, 150);
        JLabel label9 = new JLabel("START_TIME");
        frame2.getContentPane().add(label9);
        label9.setBounds(545, 04, 200, 150);
        JLabel label12 = new JLabel("END_TIME");
        frame2.getContentPane().add(label12);
        label12.setBounds(720, 04, 200, 150);
        frame2.getContentPane().add(t3);
        frame2.getContentPane().add(t4);
        frame2.getContentPane().add(t5);

        Object[][] data = { { "ASSIGNMENT COMPLETION", "1PM", "2PM" }, { "VIDEO EDITING", "2:30PM", "3PM" } };
        String[] columnNames = { "TASK", "START_TIME", "END_TIME" };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
        table.setBounds(300, 150, 500, 500);
        table.setLayout(new GridLayout(2, 1));
        frame2.add(table);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty()
                        || t5.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the boxes", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String TASK = t3.getText().toString();
                    int START_TIME = Integer.parseInt(t4.getText().toString());
                    int END_TIME = Integer.parseInt(t5.getText().toString());
                    Object[] newrow = { TASK, START_TIME, END_TIME };
                    model.addRow(newrow);
                    t3.setText(null);
                    t4.setText(null);
                    t5.setText(null);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t3.getText().toString().isEmpty() || t4.getText().toString().isEmpty()
                        || t5.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the boxes", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String task = t3.getText().toString();
                    int START_TIME = Integer.parseInt(t4.getText().toString());
                    int END_TIME = Integer.parseInt(t5.getText().toString());

                    int row = table.getSelectedRow();
                    model.setValueAt(task, row, 0);
                    model.setValueAt(START_TIME, row, 1);
                    model.setValueAt(END_TIME, row, 2);

                    t3.setText(null);
                    t4.setText(null);
                    t5.setText(null);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Please Select a row", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                int selection = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO DELETE THIS ROW", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (selection == JOptionPane.YES_OPTION) {
                    model.removeRow(table.getSelectedRow());
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame2.setVisible(false);
                frame.setVisible(true);
            }
        });
    }
}