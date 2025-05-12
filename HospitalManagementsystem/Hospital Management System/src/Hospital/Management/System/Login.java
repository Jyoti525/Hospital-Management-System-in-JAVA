package Hospital.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField passwordField;
    JButton b1,b2;

    Login(){

        JLabel namelabel=new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.RED);
        add(namelabel);

        JLabel password=new JLabel("password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.RED);
        add(password);

        textField=new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(129, 117, 67));
        add(textField);

       passwordField=new JPasswordField();
       passwordField.setBounds(150,70,150,30);
       passwordField.setFont(new Font("Tahoma",Font.PLAIN,15));
       passwordField.setBackground(new Color(129, 117, 67));
        add(passwordField);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        Image i1=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(330,-30,400,300);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
           try{
               connection c=new connection();
               String user=textField.getText();
               String password=passwordField.getText();

               String s="select * from login where ID='"+user+"' and password='"+password+"'";
               ResultSet resultSet=c.stmt.executeQuery(s);

               if(resultSet.next()){
                   new Reception();
                   setVisible(false);
               }else {
                   JOptionPane.showMessageDialog(null,"Invalid");
               }

           }catch (Exception e1){
               e1.printStackTrace();
           }
        }else {
            System.exit(10);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
