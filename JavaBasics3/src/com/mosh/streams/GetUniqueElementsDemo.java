package com.mosh.streams;

import java.util.List;

public class GetUniqueElementsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 10),
                new Movie("c", 20),
                new Movie("d", 30),
                new Movie("e", 20)
        );

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(m -> System.out.println(m));
    }
}
