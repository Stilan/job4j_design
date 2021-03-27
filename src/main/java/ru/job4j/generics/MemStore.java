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

        if (searchById(id) != -1) {
          mem.add(searchById(id), model);
          mem.remove(searchById(id));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (searchById(id) != -1) {
            mem.remove(searchById(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int searchId = searchById(id);
        return mem.get(searchId);
    }

   public int searchById(String id) {
        int idTotal = 0;
        Iterator<T> iterator = mem.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                return idTotal;
            }
            idTotal++;
        }
        return -1;
   }
}
