package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class JdbcDeleteQuery {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "YP@2462yp";
        String query = "DELETE FROM employee where id=5;";


        try {
            // Below line is used for load the jdbc Driver for query execution
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            // using connection class connection is established
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connection established successfully");
            // statement interface is used for create a statement on a connection
            Statement stmt = con.createStatement();

            // using object of statement interface execute the query
            int count = stmt.executeUpdate(query);
//            int count = stmt.getUpdateCount();
            System.out.println("rows affected is :" + count);


            con.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
