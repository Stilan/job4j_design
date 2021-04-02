package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T>{
    private Object[] container = new Object[10];
    private int size;
    int modCount = 0;
    public T get(int index) {
        Objects.checkIndex(index, size);
        T t = (T) container[index];
        return t;
    }

    public void add(T model) {
         modCount++;
        if (size == container.length) {
            Object[] copy = container;
            container = new Object[size + 1];
            System.arraycopy(copy, 0, container, 0, copy.length);
        }
            container[size] = model;
            size++;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return (T) container[i++];
            }
        };
    }
}
