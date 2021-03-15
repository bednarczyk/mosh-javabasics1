package com.mosh.streams;

import java.util.stream.IntStream;

public class PrimitiveTypeStreamDemo {
    public static void show(){
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);
    }
}
