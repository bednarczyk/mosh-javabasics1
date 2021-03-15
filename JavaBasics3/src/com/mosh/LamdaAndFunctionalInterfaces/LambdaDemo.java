package com.mosh.LamdaAndFunctionalInterfaces;

public class LambdaDemo {

    public static String prefix = "-";

    public static void print(String message){}

    public LambdaDemo(String message){}

    public static void show(){

        // Using lambda instead of anonymous inner class
        greet(message -> System.out.println(message));
        greet(System.out::println);
        greet(message -> print(message));
        greet(LambdaDemo::print);
        greet(message -> new LambdaDemo(message));
        greet(LambdaDemo::new);

        Printer printer = message -> System.out.println();

        // anonymous inner class
        greet(new ConsolePrinter());
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        greet(message -> System.out.println(prefix + message));


    }

    public static void greet(Printer printer){
        printer.print("Hello World");
    }
}
