package com.jdbcpractice;

import java.util.Scanner;

public class NumGuessingGame {
    public static void main(String[] args) {
        System.out.println("Hello world");

        int chances = 5;
        int guess;
        int num = 1 + (int)(Math.random() * 100);
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a number between 1 to 100 :");

        for (int i = 0; i <chances ; i++) {

            guess = sc.nextInt();
            if (num == guess){
                System.out.println("You guesssed it right in "+ (int)i +" chances more power to you !");
                break;
            } else if (num > guess && i != chances-1) {
                System.out.println("guess greater number");
            } else if (num < guess && i != chances-1) {
                System.out.println("guess smaller number");
            } else if (i == chances-1) {
                System.out.println("Your chances are over get lost");
                break;
            }
        }
    }
}
