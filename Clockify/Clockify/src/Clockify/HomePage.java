package Clockify;

import javax.swing.*;

import java.awt.FlowLayout;

public class HomePage {

    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Clockify");
        f.setVisible(true);
        f.setSize(800, 400);
        f.setLayout(new FlowLayout());

        JLabel l1 = new JLabel("Username");
        f.add(l1);
        JTextField t1 = new JTextField(20);
        f.add(t1);

        JLabel l2 = new JLabel("Password"); // l2
        f.add(l2);
        JTextField t2 = new JTextField(20);
        f.add(t2);
        JButton b = new JButton("Submit");
        f.add(b);

    }

}
