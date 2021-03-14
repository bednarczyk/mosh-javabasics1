package com.mosh;

public class Main {

    // alt + enter
    // new Browser + enter + alt/enter introduce local variable
    // ctrl + B = jump to implementation of method

    public static void main(String[] args) {
        //uiControl();
        //point();
        //uiControl2();
        interfacePractice();
    }

    public static void point(){
        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);
        System.out.println(point1 == point2);
        System.out.println(point1.equals(point2));
        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());
    }

    public static void interfacePractice(){
        var calculator = new TaxCalculator2018(100_000);
        var report = new TaxReport();
        report.show(calculator);
        report.show(new TaxCalculator2019());

    }

    public static void castingUpDown(){
       //var control = new UIControl(true);
        var textbox = new Textbox();
    }

    public static void show(UIControl control){
        if(control instanceof  Textbox){
            var textbox = (Textbox) control;
            textbox.setText("Hello World!");
        }
        System.out.println(control);
    }

    public static void uiControl(){
        //var control = new UIControl(true);
        //control.disable();
        //System.out.println(control.isEnabled());

        var textbox = new Textbox();
        textbox.setText("I'm a textbox");
        System.out.println("Textbox text: " + textbox.getText() + " Is enabled: " + textbox.isEnabled());
        System.out.println(textbox);

        var textbox2 = textbox;

        System.out.println(textbox.hashCode());
        System.out.println(textbox2.hashCode());
        System.out.println(textbox.equals(textbox2));
    }

    public static void uiControl2(){
        UIControl[] controls = {new Textbox(), new CheckBox()};
        for (var control : controls){
            control.render();
        }
    }

    public static void mortgageCalculator(){
        var principal = (int) Console.readNumber(
                "Principal ($1k - $1M): ", 1000, 1_000_000);
        var annualInterest = (float) Console.readNumber(
                "Annual interest rate: ", 1, 30);
        var periodYears = (byte) Console.readNumber(
                "Period (years): ", 1, 30);
        var calculator = new MortgageCalculator(principal, annualInterest, periodYears);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

    public static void employee(){
        var employee = new Employee(50_000, 20);
        employee.calculateWage(10);
        var employee2 = new Employee(60_000, 20);
        System.out.println(Employee.numberOfEmployees);
        Employee.printNumberOfEmployees();
    }
}
