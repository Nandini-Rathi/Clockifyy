package Clockify;

import java.sql.*;

public class Creation {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jbdc.Driver");
            String url = "jdbc:mysql://localhost:3306/clockify";
            String username = "root";
            String password = " hello";
            Connection con = DriverManager.getConnection(url, username, password);
            String q = "create table schedule(tTasknumber int(20) primary key auto_increment, tTaskname varchar(200) not null, tFrom int(20))  tTo int(20)";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("table created in database");

            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
