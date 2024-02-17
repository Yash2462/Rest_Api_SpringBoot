package com.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "YP@2462yp";

        String WithdrawQuery = "update accounts set balance = balance - ? where account_number =?";
        String DepositQuery = "update accounts set balance = balance + ? where account_number =?";



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection is established");
            con.setAutoCommit(false);
         try {


             PreparedStatement withdrawStatement = con.prepareStatement(WithdrawQuery);
             PreparedStatement depositStatement = con.prepareStatement(DepositQuery);

             withdrawStatement.setDouble(1, 500.00);
             withdrawStatement.setString(2, "account123");

             depositStatement.setDouble(1, 500.00);
             depositStatement.setString(2, "account456");
            int rowsAffectedWithdrawal =  withdrawStatement.executeUpdate();
            int rowsAffectedDeposited = depositStatement.executeUpdate();

            if (rowsAffectedWithdrawal>0 && rowsAffectedDeposited>0){

                con.commit();
                System.out.println("Transaction successful");
            }else
            {
                con.rollback();
                System.out.println("Transaction Failed !");
            }
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
