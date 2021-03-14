package com.mosh.generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second){
        return (first.compareTo(second) < 0) ? second : first;
    }

    // K and V are a common convention but not necessary
    public static <K, V> void print(K key, V value){
        System.out.println(key + " = " + value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    // class CAP#1 extends User {}
    // class Instructor extends User
    public static void printUsers
            (GenericList<? extends User> users){
        User x = users.get(0);
    }

    // Wildcards let us cast generic types
    // Read from - use extends keyword
    // Add to - use super keyword
    public static void addUser(GenericList<? super User> users, User user){
        users.add(user);
    }
}
