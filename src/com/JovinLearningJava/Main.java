package com.JovinLearningJava;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int months_in_year = 12;
        final int percent = 100;

        Scanner scanner = new Scanner(System.in);
        int principal;
        while (true){
            System.out.print("Enter Principal (must be between $1K - $1M): ");
            principal = scanner.nextInt();
            if ((principal >= 1000) && (principal <= 1_000_000)){
                break;
            }
            System.out.println("Please Enter Principal value between $1K and $1M");
        }

        float annual_interest_rate;
        float monthly_interest_rate;
        while(true){
            System.out.print("Annual Interest Rate: ");
            annual_interest_rate = scanner.nextFloat();
            if ((annual_interest_rate >0) && (annual_interest_rate <=30)){
                //System.out.print(annual_interest_rate);
                break;
            }
            System.out.println("Please enter a rate value greater than 0 and less than or equal to 30.");
        }

        monthly_interest_rate = (annual_interest_rate / percent) / months_in_year;

        byte period;
        while(true){
            System.out.print("Period(Years): ");
            period = scanner.nextByte();
            if ((period >= 1) && (period <=30)){
                break;
            }
            System.out.println("Please enter a value between 1 and 30.");
        }

        int numberofPayments = period * 12;

        double mortgage = principal * ((monthly_interest_rate * Math.pow(1+ monthly_interest_rate,  numberofPayments))
                / ((Math.pow(1 + monthly_interest_rate ,numberofPayments)-1)));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
