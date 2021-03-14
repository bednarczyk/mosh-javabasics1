package com.mosh.LamdaAndFunctionalInterfaces;

public interface Printer {
    void print(String message);

//    default void printTwice(String message){
//        System.out.println(message);
//        System.out.println(message);
//    }
}

// this is still a functional interface because it has a single abstract method
// doesn't matter if it has any default or static methods - only needs single abstract method
