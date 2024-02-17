package com.jdbcpractice;

import java.sql.*;

public class selectQuery2 {
    public static void main(String[] args)  throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "YP@2462yp";
        String query = "select * from student_details";

        try {
            // This Below line used for load the driver for query execution
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded successfully Now you can execute your sql query");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connection is established successfully ");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int studentId = rs.getInt("studentId");
                String StudentName = rs.getString("studentName");
                String StudentCity = rs.getString("studentCity");
                String course = rs.getString("course");

                System.out.println("StudentId :" + studentId);
                System.out.println("StudentName :" + StudentName);
                System.out.println("StudentCity :" + StudentCity);
                System.out.println("Course :" + course);

                System.out.println("======================================");
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
