package Hospital.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    Connection con;
    Statement stmt;

    public connection(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","qwerty@1");
            stmt=con.createStatement();

        }catch(Exception e){
            e.printStackTrace();

        }

    }
}
