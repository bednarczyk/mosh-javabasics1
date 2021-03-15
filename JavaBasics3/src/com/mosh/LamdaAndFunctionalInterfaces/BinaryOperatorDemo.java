package com.mosh.LamdaAndFunctionalInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class BinaryOperatorDemo {
    public static void show(){
        var x = 1 + 2;

        // add a + b then get the square of teh result
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> square = a -> a * a;

        var result = add.andThen(square).apply(1, 2);
        System.out.println(result);
    }
}
