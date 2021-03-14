package com.mosh.interfaces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void show(){
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");
        System.out.println(set);
        // Can pass a collection with repeated elements to set as a shortcut to eliminate dupes
        HashSet<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        HashSet<String> set2 = new HashSet<>(Arrays.asList("b", "c", "d"));

        // Union
        set1.addAll(set2);
        System.out.println(set1);

        // Intersection
        set1.retainAll(set2);
        System.out.println(set1);

        // Difference - what do we have in first set that we do not have in second set?
        set1.removeAll(set2);
        System.out.println(set1);
    }
}
