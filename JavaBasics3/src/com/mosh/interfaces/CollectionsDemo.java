package com.mosh.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show(){
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");

        Collections.addAll(collection, "d", "e", "f");

        for(var item : collection){
            System.out.println(item);
        }

        String[] strings = collection.toArray(new String[0]);
        for(var string : strings){
            System.out.println(string);
        }

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection.equals(other));
    }
}
