package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password ="YP@2462yp";
        String query = "select * from employee where id=?;";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded successfully 😁");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection created successfully  😉");
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.addBatch("insert into employee(id,name,work) values (6,'xyz','star')");
            statement.addBatch("insert into employee(id,name,work) values (7,'abc','silver')");
            statement.addBatch("insert into employee(id,name,work) values (8,'def','gold')");

          int[] rowsAffected =  statement.executeBatch();
          con.commit();
            System.out.println("Batch Executed successfully");

            System.out.println("RowsAffected :"+rowsAffected);
         }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
