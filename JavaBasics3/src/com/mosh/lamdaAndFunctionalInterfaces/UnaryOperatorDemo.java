package com.mosh.lamdaAndFunctionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void show(){
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        var result = increment.andThen(square).apply(1);
        System.out.println(result);
    }
}
