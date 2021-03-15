package com.mosh;

import com.mosh.LamdaAndFunctionalInterfaces.BinaryOperatorDemo;
import com.mosh.LamdaAndFunctionalInterfaces.FunctionDemo;
import com.mosh.LamdaAndFunctionalInterfaces.PredicateDemo;
import com.mosh.LamdaAndFunctionalInterfaces.UnaryOperatorDemo;
import com.mosh.exceptions.ExceptionsDemo;
import com.mosh.generics.*;
import com.mosh.streams.StreamsDemo;

public class Main {

    public static void main(String[] args) {
        //exceptions();
        //comparable();
        //utils();
        //collections();
        //CollectionsDemo.show();
        //ListDemo.show();
        //ComparableDemo.show();
        //QueueDemo.show();
        //SetDemo.show();
        //MapDemo.show();
        //LambdaDemo.show();
        //ConsumerDemo.show();
        //SupplierDemo.show();
        //FunctionDemo.show();
        //PredicateDemo.show();
        //BinaryOperatorDemo.show();
        //UnaryOperatorDemo.show();
        StreamsDemo.show();
    }

    public static void collections(){
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        for(var item : list) {
            System.out.println(item);
        }
    }

    public static void genericInheritance(){
        User user = new Instructor(10);
        Utils.printUser(new Instructor(20));
        var instructors = new GenericList<Instructor>();
        Utils.printUsers(instructors);
    }

    public static void utils(){
        Utils.print(1, "Doug");
    }

    public static void comparable(){
        var user1 = new User(10);
        var user2 = new User(20);
        if(user1.compareTo(user2) < 0)
            System.out.println("user1 < user2");
        else if (user1.compareTo(user2) == 0)
            System.out.println("user1 == user2");
        else
            System.out.println("user1 > user 2");

        System.out.println("Bigger user: " + Utils.max(user1, user2));

    }

    public static void generics(){
        var list = new List();
        list.add(1);

        var genericList = new GenericList<Integer>();
        genericList.add(1); // Boxing - Java automatically wraps  eg primitive int into wrapper Integer
        int i = list.get(0); // Unboxing - Java automatically converts to primitive eg Integer to int

        var userList = new GenericList<User>();
        userList.add(new User(10));
    }

    public static void exceptions(){
        try {
            ExceptionsDemo.show();
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");
        }
    }

}
