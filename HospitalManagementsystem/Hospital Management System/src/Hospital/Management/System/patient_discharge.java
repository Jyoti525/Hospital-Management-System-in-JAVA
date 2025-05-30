package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge  extends JFrame {

    patient_discharge(){

        JPanel panel =new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("check-out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);


        JLabel label2=new JLabel("Customer Id");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            connection c=new connection();
            ResultSet resultSet=c.stmt.executeQuery("select * from Patient_Info1");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3=new JLabel("Room number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setForeground(Color.white);
        panel.add(label3);

        JLabel RNO=new JLabel();
        RNO.setBounds(200,130,150,20);
        RNO.setFont(new Font("Tahoma",Font.BOLD,14));
        RNO.setForeground(Color.white);
        panel.add(RNO);

        JLabel label4=new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel INTime=new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.white);
        panel.add(INTime);

        JLabel label5=new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();
        JLabel OUTTime =new JLabel(""+date );
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);

        JButton discharge= new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 30); // Adjusted Y position to be visible
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c=new connection();
                try {
                    c.stmt.executeUpdate("delete from Patient_Info1 where number='" + choice.getSelectedItem() + "'");
                    c.stmt.executeUpdate("update room set Availability='Available' where room_no='"+RNO.getText()+"'");
                    JOptionPane.showMessageDialog( null,"Done");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }

            }
        });

        JButton check= new JButton("Check");
        check.setBounds(170, 300, 120, 30); // Adjusted Y position to be visible
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c=new connection();
                try{
                    ResultSet  resultSet=c.stmt.executeQuery("select * from Patient_Info1 where number='"+choice.getSelectedItem()+"'" );
                    while(resultSet.next()) {
                        RNO.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));

                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back= new JButton("Back");
        Back.setBounds(300, 300, 120, 30); // Adjusted Y position to be visible
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_discharge();

    }
}
