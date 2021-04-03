package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[10];
    private int size;
    private int modCount = 0;
    public T get(int index) {
        Objects.checkIndex(index, size);
        T t = (T) container[index];
        return t;
    }

    public void add(T model) {
         modCount++;
        if (size == container.length) {
          container = arrayExpansion(container);
        }
            container[size] = model;
            size++;
    }
    public Object[] arrayExpansion(Object[] array) {
        array = Arrays.copyOf(array, array.length + 10);
        return array;
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
