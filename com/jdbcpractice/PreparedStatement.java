package com.jdbcpractice;


import java.sql.*;

public class PreparedStatement {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password ="YP@2462yp";
//        String update_query = "update employee set name=? where id=?;";
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
            Statement stmt = con.createStatement();
//            java.sql.PreparedStatement preparedStatement = con.prepareStatement(update_query);
            java.sql.PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,4);
//              preparedStatement.setString(1,"Taylor Swift");
//              preparedStatement.setInt(2,4);
//              preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String work = rs.getString("work");

                System.out.println("id is :"+id);
                System.out.println("name is :"+name);
                System.out.println("work is :"+work);
            }
            con.close();
            preparedStatement.close();
            rs.close();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
