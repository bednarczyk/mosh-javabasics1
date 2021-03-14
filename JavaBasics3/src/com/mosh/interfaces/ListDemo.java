package com.mosh.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListDemo {
    public static void show(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(0, "!");
        Collections.addAll(list, "d", "e", "f");
        list.remove(6);
        System.out.println(list);
        System.out.println(list.indexOf("a"));
        list.add("a");
        System.out.println(list.lastIndexOf("a"));
        System.out.println(list.subList(0,3));

        ArrayList<String> responses = new ArrayList<>();
        responses.add("What? I didn't understand you.");
        responses.add("I'm sorry, I don't understand.");
        responses.add("I'm not sure I understand.");
        responses.add("Not sure what you are asking.");

        Random rand = new Random();
        System.out.println(responses.get(rand.nextInt(responses.size())));
    }
}
