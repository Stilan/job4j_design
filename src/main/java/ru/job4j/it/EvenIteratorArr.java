package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIteratorArr implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIteratorArr(int[] data) {
        this.data = data;
    }

    public boolean isNumberIsEven(int number) {
        return number % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = point; i < data.length; i++) {
            if (isNumberIsEven(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!isNumberIsEven(data[point])) {
            point++;
        }
        return data[point++];
    }
}
