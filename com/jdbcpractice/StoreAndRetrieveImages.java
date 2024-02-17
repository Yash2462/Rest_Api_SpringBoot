package com.jdbcpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreAndRetrieveImages {
    public static void main(String[] args) {
        String url = "";
        String username = "root";
        String password = "YP@2462yp";
        // load path of image
        String path = "E:\\SQL_QUESTIONS\\image\\yash_image.jpg";
        String query  = "insert into image_details(image_data) values(?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection created ");

            FileInputStream fileInputStream = new FileInputStream(path);
            byte[] image_arr = new byte[fileInputStream.available()];
            fileInputStream.read(image_arr);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBytes(1,image_arr);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0){
                System.out.println("insertion is successfull");
            }
            else {
                System.out.println("insertion is failed");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

