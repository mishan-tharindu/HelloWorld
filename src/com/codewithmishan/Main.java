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
        float monthlyInterest;
        int numberOfPayments;

        System.out.println("Welcome to Mortgage Calculator!!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        clientName = scanner.nextLine().trim();
        System.out.println("Hi, "+ clientName + " Welcome to Mortgage Calculator");

        while (true)
        {
            System.out.print("Enter Your Capital Amount ($1k - $1M): ");
            capital = scanner.nextInt();
            if(capital>= 1000 && capital <= 1_000_000)
            {
                break;
            }
           System.out.println("Please Enter between 100k to 1M");


        }

        while (true)
        {
            System.out.print("Enter Your Annual Interest Rate : ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30)
            {
                monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
                System.out.println("Plese enter Value Between 1 and 30");
        }


        while (true)
        {
            System.out.print("Enter Your Period (Years) : ");
            period = scanner.nextByte();
            if(period >= 1 && period <= 30)
            {
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");

        }

        mortgage = capital
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageCurrency = currency.format(mortgage);

        System.out.println("Mortgage : "+ mortgageCurrency);

    }

}