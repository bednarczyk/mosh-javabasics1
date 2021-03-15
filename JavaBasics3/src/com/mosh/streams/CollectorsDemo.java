package com.mosh.streams;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 10),
                new Movie("c", 20),
                new Movie("d", 30),
                new Movie("e", 20)
        );

        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        System.out.println(result);

        var result2 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(result2);

        var result3 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));

        System.out.println(result3);
    }
}
