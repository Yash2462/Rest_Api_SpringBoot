package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class JdbcUpdateQuery {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "YP@2462yp";
        String query = "UPDATE employee SET name = 'Don' , salary = 40000.0 WHERE id=4";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully .");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);
            con.close();
            stmt.close();
            System.out.println("Rows affected are :"+rowsaffected);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
