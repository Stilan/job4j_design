package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size;


    public SimpleArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public SimpleArray() {
    }

    public void add(T model) {
       array[size] = model;
       size++;
    }
    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    public void remove(int index) {
      int start = index + 1;
      int length = size - index;
      System.arraycopy(array, start, array, index, length);
      array[size - 1] = null;
      size--;
    }

    public Object get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
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
                return array[i++];
            }
        };
      }
}
