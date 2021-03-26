package com.mosh.streams;

import com.mosh.lamdaAndFunctionalInterfaces.PartitioningDemo;

import java.util.List;

public class StreamsDemo {
    public static void show(){

        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Imperative Programming (How)
        int count = 0;
        for (var movie : movies){
            if (movie.getLikes() >10)
                count++;
        }

        // Declarative Programming (What)
        // Streams were introduced to allow us to process a collection of objects in a declarative way
        // Stream is a sequence of objects. Collection is like water tank, stream is like pipe.
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();

        CreatingStreamsDemo.show();
        MappingDemo.show();
        SlicingDemo.show();
        SortingDemo.show();
        System.out.println();
        GetUniqueElementsDemo.show();
        System.out.println("Peeking Demo");
        PeekingDemo.show();
        System.out.println("Reducing Demo");
        ReducersDemo.show();
        System.out.println("Collectors");
        CollectorsDemo.show();
        System.out.println();
        GroupingDemo.show();
        System.out.println();
        PartitioningDemo.show();
        System.out.println();
        PrimitiveTypeStreamDemo.show();
    }

}
