package com.mosh.streams;

import java.util.List;
import java.util.stream.Collectors;

public class GroupingDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 10, Genre.ACTION),
                new Movie("c", 20, Genre.COMEDY),
                new Movie("d", 30, Genre.ACTION),
                new Movie("e", 20, Genre.THRILLER)
        );

        var result = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));

        System.out.println(result);
    }
    }
