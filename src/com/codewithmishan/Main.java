package com.codewithmishan;

import java.text.NumberFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        String clientName;
        int capital;
        float annualInterestRate;
        byte period;
        double mortgage;

        System.out.println("Welcome to Mortgage Calculator!!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        clientName = scanner.nextLine().trim();
        System.out.println("Hi, "+ clientName + " Welcome to Mortgage Calculator");

        System.out.print("Enter Your Capital Amount : ");
        capital = scanner.nextInt();

        System.out.print("Enter Your Annual Interest Rate : ");
        annualInterestRate = scanner.nextFloat();
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Enter Your Period (Years) : ");
        period = scanner.nextByte();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        mortgage = capital
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageCurrency = currency.format(mortgage);

        System.out.println("Mortgage : "+ mortgageCurrency);




    }

}