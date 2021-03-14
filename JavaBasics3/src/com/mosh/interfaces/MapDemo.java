package com.mosh.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show(){
        List<Customer> customers = new ArrayList<>();
//        for (var customer : customers){
//            if (customer.getEmail() == "e1")
//                System.out.println("Found!");
//        }

        // Java: Maps (hashmap)
        // C#: Dictionary
        // Python: Dictionary
        // JavaScript: Objects

        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var customer = map.get("e1");
        System.out.println(customer);

        for (var key : map.keySet())
            System.out.println(key);

        for (var entry : map.entrySet())
            System.out.println(entry);

        for (var cust : map.values())
            System.out.println(cust);

    }
}
