package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery2 {
    public static void main(String[] args)  throws  ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "YP@2462yp";
        String query = "DELETE from student_details where  studentId=4";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class loaded successfully ");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connection is created successfully");
            Statement stmt = con.createStatement();
            int affected = stmt.executeUpdate(query);

            if (affected > 0){
                System.out.println("Rows affected are :"+affected);
            }
            else{
                System.out.println("No any rows affected :"+affected);
            }
            con.close();
            stmt.close();
        }catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }
}
