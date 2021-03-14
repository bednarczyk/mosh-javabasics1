package com.mosh.interfaces;

public class Customer implements Comparable<Customer> {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Customer other) {
        // this < other -> negative
        // this == other -> 0
        // this > other -> 1
        return name.compareTo(other.name);
    }
}
