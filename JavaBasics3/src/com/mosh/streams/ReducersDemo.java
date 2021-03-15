package com.mosh.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReducersDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 10),
                new Movie("c", 20),
                new Movie("d", 30),
                new Movie("e", 20)
        );

       var result = movies.stream()
                .anyMatch(m -> m.getLikes() > 20);
        System.out.println(result);

        var result2 = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();
        System.out.println(result2.getTitle());

        Optional<Integer> sum = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);
        System.out.println(sum.orElse(0));

    }
}
