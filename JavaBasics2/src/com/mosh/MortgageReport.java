package com.mosh;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage(){
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + currency.format(
                calculator.calculateMortgage()));
        System.out.println();
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        var balances = calculator.getRemainingBalances();
        for (double balance : balances) {
            System.out.println(currency.format(balance));
        }
    }
}
