package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("update patient details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("update patient details");
        label2.setBounds(25, 88, 160, 14); // Increased width for visibility
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25); // Slightly wider
        panel.add(choice);

        try {
            connection c = new connection();
            ResultSet resultSet = c.stmt.executeQuery("select * from Patient_Info1");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number:");
        label3.setBounds(25, 129, 100, 14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In_Time:");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldIntime = new JTextField();
        textFieldIntime.setBounds(248, 174, 140, 20);
        panel.add(textFieldIntime);

        JLabel label5 = new JLabel("Pending Amount(Rs):");
        label5.setBounds(25, 216, 200, 14); // Wider label for clarity
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Amount Paid(Rs):");
        label6.setBounds(25, 261, 200, 14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);

        JButton b1 = new JButton("CHECK");
        b1.setBounds(281, 378, 89, 23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from Patient_info1 where Name='" + id + "'";
                try {
                    connection c = new connection();
                    ResultSet resultSet = c.stmt.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldIntime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }

                    ResultSet resultSet1 = c.stmt.executeQuery("select * from room where room_no='" + textFieldR.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(String.valueOf(amountPaid));
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }


            }
        });

        JButton b2 = new JButton("UPDATE");
        b2.setBounds(56, 378, 89, 23);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection c = new connection();
                    String q=choice.getSelectedItem();
                    String room=textFieldR.getText();
                    String time=textFieldIntime.getText();
                    String amount=textFieldAmount.getText();
                    c.stmt.executeUpdate("update Patient_Info set Room_Number='"+room+"', Time='"+time+"',Deposite='"+amount+"'where name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"upadated Successfully");
                    setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }


            }
        });

        JButton b3=new JButton("BACK");
        b3.setBounds(56,378,89,23);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        panel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}
