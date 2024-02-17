package com.jdbcpractice;

import java.nio.channels.ClosedSelectorException;
import java.sql.*;

public class JdbcInsertQuery {
    public static void main(String[] args)  throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "YP@2462yp";

        String query = "insert into employee (id , name , job_title , salary) values (5,'Sam','Data Engineer' , 25000.0) ;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully !");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection is established");
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            connection.close();
            stmt.close();

            if (rowsAffected > 0){
                System.out.println("Insert sccessful :" + rowsAffected + "rows affected");
            }
            else {
                System.out.println("insertion failed");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
