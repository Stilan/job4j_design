package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        if (!set.iterator().hasNext()) {
            set.add(value);
            return true;
        } else {
            for (T t : set) {
                if (!Objects.equals(t, value)) {
                        set.add(value);
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (T t: set) {
            if (Objects.equals(t, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
