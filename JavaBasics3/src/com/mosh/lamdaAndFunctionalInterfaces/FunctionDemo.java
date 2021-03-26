package com.mosh.lamdaAndFunctionalInterfaces;

import java.util.function.Function;

public class FunctionDemo {
    public static void show(){
        // Takes an argument, returns a value
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("Sky");
        System.out.println(length);

        // Composing functions
        // "key:value"
        // want to replace colon with = sign ("key=value")
        // next add curly braces: "{key=value}"
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        var result = replaceColon
                .andThen(addBraces)
                .apply("key:value");
        System.out.println(result);

        var result2 = addBraces
                .compose(replaceColon)
                .apply("key:value");
        System.out.println(result2);
    }
}
