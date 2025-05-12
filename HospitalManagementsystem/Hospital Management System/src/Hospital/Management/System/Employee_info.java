package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info() {

        // Set frame properties
        setUndecorated(true);
        setSize(990, 590); // Increased size to match panel and avoid clipping
        setLayout(null);
        setLocation(350, 250);

        JPanel panel = new JPanel();
        panel.setBounds(0, 5, 990, 590);
        panel.setLayout(null);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 960, 350); // Adjusted to better fit the frame
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            connection c = new connection();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(30, 11, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(125, 9, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setBounds(240, 9, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(350, 9, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setBounds(470, 9, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhaar No.");
        label6.setBounds(600, 9, 150, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label6);

        JButton b1 = new JButton("BACK");
        b1.setBounds(440, 410, 100, 30); // Adjusted Y position to be visible
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
