package com.mosh.LamdaAndFunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void show(){
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println(isLongerThan5.test("sky"));

        // Combining Predicates
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        Predicate<String> hasLeftAndRightBrace = hasLeftBrace.and(hasRightBrace);
        var result = hasLeftAndRightBrace.test("{Hello}");
        System.out.println(result);
        Predicate<String> hasLeftOrRightBrace = hasLeftBrace.or(hasRightBrace);
        result = hasLeftOrRightBrace.test("Hello");
        System.out.println(result);
    }
}
