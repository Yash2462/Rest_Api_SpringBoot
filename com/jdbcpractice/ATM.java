package com.jdbcpractice;


import java.util.Scanner;

public class ATM {
   static boolean isValid(){
       String name = "yash";
       int password = 123;

       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your name :");
       String Scname = sc.nextLine();
       System.out.println("Enter your password :");
       int ScPass = sc.nextInt();

       if (Scname.equalsIgnoreCase(name) && ScPass == password){
           return true;
       }

       return false;
   }
    public static void functionality(){
        System.out.println("Enter 1 for check balance :");
        System.out.println("Enter 2 for debit money :");
        System.out.println("Enter 3 for credit money :");
        System.out.println("Enter 4 for exit() :");

   }

    public static void main(String[] args) {

       if (isValid()){
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter money :");
           int amount = sc.nextInt();
           int choice;

           while (true){
               functionality();
               System.out.println("Enter your choice :");
                choice = sc.nextInt();

               switch (choice) {
                   case 1:
                       System.out.println("You have :" + amount + " ✌✌");
                       break;



                   case 2:
                       System.out.println("Enter money you want to withdraw :");
                       int withdraw = sc.nextInt();
                       if (amount > withdraw){
                           amount = amount - withdraw;
                           System.out.println("Collect your money");

                           break;
                       }
                       else {
                           System.out.println("insufficient amount");
                           System.exit(0);
                       }


                   case 3:
                       System.out.println("Enter money you want to credit :");
                       int credit = sc.nextInt();
                       amount += credit;
                       break;

                   case 4:
                       System.out.println("Please Remove Your Card 😁");
                       System.exit(0);
               }

           }
       }
       else {
           System.out.println("You are not authorised user !");
       }

    }
}