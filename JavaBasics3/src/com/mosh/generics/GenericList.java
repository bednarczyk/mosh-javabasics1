package com.mosh.generics;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// Common convention T for Type/Template or E for element
// Can have T extend classes or interfaces, for example, to only support number classes <T extends Number>
// or <T extends Comparable & Cloneable>
// We say that we have a bounded type parameter

public class GenericList<T> implements Iterable<T>{
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
        private GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
