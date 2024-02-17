package com.jdbcpractice;

import java.util.Scanner;

public class NumGuess {

    public static void main(String[] args) {
        int chances = 5;
        Scanner sc = new Scanner(System.in);
        int num = 1 + (int)(Math.random()*100);
        System.out.println("Enter your Guess :");
        int guess;
        for (int i = 0; i <chances ; i++) {
             guess = sc.nextInt();
            if (num > guess && i< chances-1){
                System.out.println("Guess higher values :");
            }
            else if (num < guess && i < chances-1) {
                System.out.println("Guess lower values :");
            }
            else if (i == chances-1){
                System.out.println("Chances are exhausted");
                System.out.println("Number was :"+num);
            }
            else {
                System.out.println("You guesssed it right");
                break;
            }
        }
    }
}
