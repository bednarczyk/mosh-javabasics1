package com.mosh;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {

    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last){
            first = last = null;
        }
        Node second = first.next;
        first = null;
        first = second;
    }

    public void deleteLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        if (last == first){
            first = last = null;
            return;
        }

        var previous = getPrevious(last);
        if (previous != null) {
            previous.next = null;
            last = null;
            last = previous;
        }
    }

    private Node getPrevious (Node node){
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }
    public boolean contains(int value) {
       /*
        var current = first;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
        */
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        int i = 0;
        var current = first;
        while (current != null) {
            if (current.value == value) return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

}
