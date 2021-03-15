package com.mosh.streams;

import java.util.List;
import java.util.stream.Stream;

public class MappingDemo {
    public static void show(){
        var movies = List.of(
                new Movie("The Lion King", 10),
                new Movie("Moana", 20),
                new Movie("The Princess and the Frog", 30)
        );

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(name -> System.out.println(name));

        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        stream.forEach(list -> System.out.println(list));

        var stream2 = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        stream2
                .flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));

    }
}
