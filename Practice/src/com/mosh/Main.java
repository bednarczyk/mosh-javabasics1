package com.mosh;

//Ctl+S


import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    final static int MONTHS_IN_YEAR = 12;
    final static int PERCENT = 100;

    public static void main(String[] args) {

        // Deploy: Main class - File - Project Structure - Artifacts - Add - JAR - from modules with dependencies
        // select Main class - Build menu - Select build artifacts - Build
        // Project panel - out - artifacts - context menu open


        // shift + F6 = refactor/rename
        // Ctrl + Alt + Shift + L = reformat code
        //byte > short > int > long > float > double
        //stringPractice();
        //referenceTypesPractice();
        //primitiveTypesPractice();
        //arrayPractice();
        //formattingNumbers();
        //readingInput();
        mortgageCalculator();
        //ternarySwitch();
        //fizzBuzz();
        //loop();

    }

    private static void loop() {
        // keep getting input from user until they type 'quit'
        // continue moves control back to beginning of loop without executing lines below it but without breaking

        var scanner = new Scanner(System.in);
        var message = "";
        while (true) {
            System.out.print("Type something: ");
            message = scanner.nextLine();
            if (message.equalsIgnoreCase("pass"))
                continue;
            if (message.equalsIgnoreCase("quit"))
                break;
            System.out.println("Echo: " + message);
        }

        do {
            System.out.print("Type something: ");
            message = scanner.nextLine();
            System.out.println("Echo: " + message);
        } while (!message.equalsIgnoreCase("quit"));


        // for-each
        String[] fruits = {"Apple", "Mango", "Orange"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

    }

    private static void ternarySwitch() {
        int income = 120_000;
        String className = income > 100_000 ? "First" : "Economy";
        System.out.println(className);

        String role = "admin";
        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;

            case "moderator":
                System.out.println("You're a moderator");
                break;

            default:
                System.out.println("You're a guest");
        }

    }

    private static void fizzBuzz() {
        // Often used in interviews
        // if inputted number is divisible by 5 you get fizz
        // if divisible by 3 you get buzz
        // if divisible by both you get fizzBuzz
        // otherwise you get the number back

        var scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        var number = scanner.nextInt();
        boolean divFive = (number % 5 == 0);
        boolean divThree = (number % 3 == 0);

        if (divFive && divThree)
            System.out.println("FizzBuzz");
        else if (divFive)
            System.out.println("Fizz");
        else if (divThree)
            System.out.println("Buzz");
        else
            System.out.println(number);

    }

    private static void mortgageCalculator() {

        int principal = (int) readNumber("Principal ($1k - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual interest rate: ", 1, 30);
        byte periodYears = (byte) readNumber("Period (years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, periodYears);
        printMortgage(mortgage);
        printPaymentSchedule(principal, annualInterest, periodYears);

        int monthOfPayment = (int) readNumber("See balance at month: ", 0, 30*MONTHS_IN_YEAR);
        double balance = getBalanceAtPoint(principal, annualInterest, periodYears, monthOfPayment);
        System.out.println("Balance at month "
                + monthOfPayment
                + ": " + NumberFormat.getCurrencyInstance().format(balance));

    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte periodYears) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for (int month = 1; month <= periodYears * MONTHS_IN_YEAR; month++) {
            var balance = calculateBalance(month, principal, annualInterest, periodYears);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static double getBalanceAtPoint(int principal,
                                            float annualInterest,
                                            byte periodYears,
                                            int monthOfPayment) {
        var balance = calculateBalance(monthOfPayment, principal, annualInterest, periodYears);
        return balance;
    }

    private static void printMortgage(double mortgage) {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
        System.out.println();
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        var numPayments = years * MONTHS_IN_YEAR;
        var monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        var mortgage = principal * ((monthlyInterest * Math.pow((1 + monthlyInterest), numPayments))
                / (Math.pow((1 + monthlyInterest), numPayments) - 1));

        return mortgage;

    }

    private static double calculateBalance(int numberOfPaymentsMade,
                                           double principal,
                                           float annualInterest,
                                           byte years) {

        final int MONTHS = 12;
        final int PERCENT = 100;

        var numPayments = years * MONTHS;
        float monthlyInterest = annualInterest / PERCENT / MONTHS;

        var balance = principal *
                ((Math.pow((1 + monthlyInterest), numPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                        / (Math.pow((1 + monthlyInterest), numPayments) - 1));

        return balance;

    }

    public static double readNumber(String prompt, double min, double max) {

        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }

        return value;

    }


    private static void readingInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.next().trim(); // scanner.nextLine() for multiple tokens, ie first and last name
        System.out.print("Age: ");
        byte age = scanner.nextByte();
        System.out.println(name + ", you are " + age + " years old");

    }


    private static void formattingNumbers() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(1234567.891);
        System.out.println(result);
        System.out.println(NumberFormat.getPercentInstance().format(123.57));

        // abstract class - cannot instantiate. Use factory to get object.

    }

    private static void arrayPractice() {
        int[][] numbers = new int[2][3];
        int[][] numbers2 = {{1, 2, 3}, {4, 5, 6}};
        numbers[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers));
        System.out.println(Arrays.deepToString(numbers2));
    }

    private static void stringPractice() {
        // String is reference type even though it looks like a primitive
        String message = "Hello World";
        String modifiedMessage = message.replace("World", "Dani");
        System.out.println(message);
        System.out.println(modifiedMessage);
    }

    private static void primitiveTypesPractice() {
        byte age = 30;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(y);
    }

    private static void referenceTypesPractice() {
        byte age = 30;
        Date now = new Date();
        System.out.println(now);

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

    }

    private static void linkedListPractice() {

        //Linked Lists
        LinkedList list = new LinkedList();
        System.out.println(list);
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.addLast(7);
        list.addFirst(6);
        System.out.println(list);
        System.out.println("List contains " + 20 + "? : " + list.contains(20));
        System.out.println("List size: " + list.size());
        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        var myList = new com.mosh.LinkedList();
        myList.print();
        //myList.deleteLast();
        //myList.deleteFirst();
        myList.addFirst(10);
        myList.deleteLast();
        myList.print();
        myList.addFirst(9);
        myList.addLast(11);
        myList.addFirst(8);
        myList.addLast(12);
        myList.addFirst(7);
        myList.addLast(13);
        myList.print();
        System.out.println("Delete first");
        myList.deleteFirst();
        myList.print();
        System.out.println("Delete last");
        myList.deleteLast();
        myList.print();
        System.out.println("Contains 11? " + myList.contains(11));
        System.out.println("Contains 51? " + myList.contains(51));
        System.out.println("Index of 9: " + myList.indexOf(9));
        System.out.println("Index of 51: " + myList.indexOf(51));

    }
}
