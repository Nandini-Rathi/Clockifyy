package Clockify;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.GridLayout;

public class Settings {
    public static void main(String[] args) {
        new Mytable();
    }
}

class Mytable extends JFrame {
    JTable table;
    JButton b1, b2, b3;
    JTextField t1, t2, t3;

    Mytable() {
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Object[][] data = { { "A", 1, 2 }, { "B", 2, 3 } };
        String[] columnNames = { "Taskname", "From", "To" };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        setLayout(new GridLayout(2, 1));
        JPanel pan = new JPanel();

        add(new JScrollPane(table));
        add(new JPanel());
        add(pan);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        b1 = new JButton("Add");
        b2 = new JButton("Update");
        b3 = new JButton("Delete");

        pan.setLayout(new GridLayout(3, 3));
        pan.add(new JLabel("Taskname"));
        pan.add(t1);
        pan.add(b1);
        pan.add(new JLabel("From"));
        pan.add(t2);
        pan.add(b2);
        pan.add(new JLabel("To"));
        pan.add(t3);
        pan.add(b3);

        validate();

        // ADD
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()
                        || t3.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the boxes", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String taskname = t1.getText().toString();
                    int from = Integer.parseInt(t2.getText().toString());
                    int to = Integer.parseInt(t3.getText().toString());
                    Object[] newrow = { taskname, from, to };
                    model.addRow(newrow);
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                }
            }
        });

        // UPDATE
        table.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIndex = table.getSelectedRow();
                String taskname = (String) model.getValueAt(rowIndex, 0);
                int from = (int) model.getValueAt(rowIndex, 1);
                int to = (int) model.getValueAt(rowIndex, 2);
                t1.setText(taskname);
                t2.setText(String.valueOf(from));
                t3.setText(String.valueOf(to));
            }
        });

        // UPDATE
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()
                        || t3.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the boxes", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String taskname = t1.getText().toString();
                    int from = Integer.parseInt(t2.getText().toString());
                    int to = Integer.parseInt(t3.getText().toString());

                    int row = table.getSelectedRow();
                    model.setValueAt(taskname, row, 0);
                    model.setValueAt(from, row, 1);
                    model.setValueAt(to, row, 2);

                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                }
            }
        });

        // Delete
        b3.addActionListener(new ActionListener() {
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
    }
}