package com.mosh.streams;

import java.util.List;

public class PeekingDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 10),
                new Movie("c", 20),
                new Movie("d", 30),
                new Movie("e", 20)
        );

        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("Filtered: " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("Mapped: " + t))
                .forEach(System.out::println);
    }
    }
