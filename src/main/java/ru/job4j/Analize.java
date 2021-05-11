package ru.job4j;

import java.util.*;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = current.size() > previous.size() ? current.size() - previous.size() : 0;
        info.deleted = previous.size() > current.size() ? previous.size() - current.size() : 0;
        info.changed = 0;
        for (int i = 0; i < previous.size() - info.deleted; i++) {
            if (!previous.get(i).name.equals(current.get(i).name)) {
                info.changed++;
            }
        }
        return info;
    }
}
