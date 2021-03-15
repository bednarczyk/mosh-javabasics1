package com.mosh.streams;

import java.util.List;

public class SlicingDemo {
    public static void show(){
        // limit(n)
        // skip(n)
        // takeWhile(predicate)
        // dropWhile(predicate)

        List<Movie> movies = List.of(
                new Movie("Anna", 10),
                new Movie("Beauty", 30),
                new Movie("Cinderella", 20)
        );

        movies.stream()
                .limit(2)
                .forEach(m -> System.out.println(m.getTitle()));

        System.out.println();

        movies.stream()
                .skip(2)
                .forEach(m -> System.out.println(m.getTitle()));

        System.out.println();

        // Let's say we have 1000 movies
        // display 10 movies per page
        // interested in 3rd page
        // skip( (page-1) x pageSize )
//        movies.stream()
//                .skip(20)
//                .limit(10)
//                .forEach(m -> System.out.println(m.getTitle()));

        // takeWhile() stops as soon as the condition becomes false, as opposed to filter which goes through all
        movies.stream()
                .takeWhile(m -> m.getLikes() < 30)
                .forEach(m -> System.out.println(m.getTitle()));

        System.out.println();

        // dropWhile()
        movies.stream()
                .dropWhile(m -> m.getLikes() < 30)
                .forEach(m -> System.out.println(m.getTitle()));
    }

}
