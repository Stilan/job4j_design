package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();
    @Override
    public void add(T model) {
       mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).equals(findById(id))) {
                mem.remove(i);
                mem.add(i, model);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).equals(findById(id))) {
                mem.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        Iterator<T> iterator = mem.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

}
