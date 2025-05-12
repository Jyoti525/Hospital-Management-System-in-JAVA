package Hospital.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250, 11, 186, 31);
        For.setFont(new Font("Tahoma", Font.BOLD, 20));
        For.setForeground(Color.white);
        panel.add(For);

        JLabel status = new JLabel("Status");
        status.setBounds(70, 70, 80, 20);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        status.setForeground(Color.white);
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170, 70, 120, 20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 187, 700, 210);
        table.setBackground(new Color(90, 156, 163));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        // Load all rooms initially
        try {
            connection c = new connection();
            String q = "select * from room";
            ResultSet resultSet = c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23, 162, 150, 20);
        rn.setFont(new Font("Tahoma", Font.BOLD, 14));
        rn.setForeground(Color.WHITE);
        panel.add(rn);

        JLabel av = new JLabel("Availability");
        av.setBounds(175, 162, 150, 20);
        av.setFont(new Font("Tahoma", Font.BOLD, 14));
        av.setForeground(Color.WHITE);
        panel.add(av);

        JLabel price = new JLabel("Price");
        price.setBounds(345, 162, 120, 20);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(525, 162, 120, 20);  // Corrected position
        bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);

        JButton b1 = new JButton("SEARCH");
        b1.setBounds(200, 420, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "select * from room where Availability='" + choice.getSelectedItem() + "'";
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.stmt.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("BACK");
        b2.setBounds(350, 420, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(450, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
