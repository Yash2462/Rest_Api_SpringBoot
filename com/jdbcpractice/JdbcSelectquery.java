package com.jdbcpractice;

import java.sql.*;

public class JdbcSelectquery {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "YP@2462yp";
        String query = "select * from employee;";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("connection is established successfully");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println(" id : " + id);
//                System.out.println("================");
                System.out.println("name:" + name);
//                System.out.println("================");
                System.out.println("job_title: " + job_title);
//                System.out.println("================");
                System.out.println("salary: " + salary);
                System.out.println("================");
            }
            rs.close();
            connection.close();
            stmt.close();
            System.out.println("connection closed successfully");
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
