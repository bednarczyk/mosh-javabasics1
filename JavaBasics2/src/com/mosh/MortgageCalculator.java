package com.mosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    final private int MONTHS_IN_YEAR = 12;
    final private int PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte periodYears;

    private double mortgage;

    public MortgageCalculator(int principal, float annualInterest, byte periodYears){
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setPeriodYears(periodYears);
    }

    private float getMonthlyInterest(){
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public double calculateMortgage(){
        var monthlyInterest = getMonthlyInterest();
        var numberOfPayments = getNumberOfPayments();
        mortgage = principal * ((monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));

        return mortgage;
    }


    public double getMortgage(){
        return mortgage;
    }

    public double calculateBalance(int numberOfPaymentsMade){
        var monthlyInterest = getMonthlyInterest();
        var numberOfPayments = getNumberOfPayments();
        var balance = principal *
                ((Math.pow((1 + monthlyInterest), numberOfPayments)
                        - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                        / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));

        return balance;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month-1] = calculateBalance(month);
        }
           return balances;
        }

        private void setPrincipal ( int principal){
            this.principal = principal;
        }


        private void setAnnualInterest ( float annualInterest){
            this.annualInterest = annualInterest;
        }

        private void setPeriodYears ( byte periodYears){
            this.periodYears = periodYears;
        }

        public int getNumberOfPayments(){
            return periodYears * MONTHS_IN_YEAR;
        }
    }

