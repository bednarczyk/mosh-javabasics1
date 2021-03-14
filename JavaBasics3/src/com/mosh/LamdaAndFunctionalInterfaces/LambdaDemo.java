package com.mosh.LamdaAndFunctionalInterfaces;

public class LambdaDemo {
    public static void show(){

        // Using lambda instead of anonymous inner class
        greet(message -> System.out.println(message));

        Printer printer = message -> System.out.println();

        // anonymous inner class
        greet(new ConsolePrinter());
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });


    }

    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
