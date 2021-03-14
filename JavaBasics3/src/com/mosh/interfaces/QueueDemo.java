package com.mosh.interfaces;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show(){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        queue.offer("d");
        // d -> b -> a -> c
        var front = queue.peek(); // queue.element also shows first but throws exception if queue is empty
        System.out.println(front);
        front = queue.remove(); // queue.poll also removes first element but returns null if empty
                                // while remove throws exception
        System.out.println(front);
        System.out.println(queue.peek());



    }
}
