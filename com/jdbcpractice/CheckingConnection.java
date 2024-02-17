package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckingConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Students";

        String username = "root";
        String password = "YP@2462yp";

        try(Connection conncection = DriverManager.getConnection(url , username, password)) {
            System.out.println("Connection Established successfully");
            // by using below code we can get conncetion id
            System.out.println(conncection);
        } catch (SQLException e){
            System.out.println("Conncetion Failed :" + e.getMessage());
        }
    }
}
