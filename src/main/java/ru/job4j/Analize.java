package ru.job4j;

import java.util.*;

public class Analize {
    static int sumDeleted = 0;
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = 0;
        Map<Integer, User> userMap = new HashMap<>();
        for (User users:current) {
            userMap.put(users.id, users);
        }
        for (User users: previous) {
            if (userMap.containsKey(users.id) && !userMap.containsValue(users)) {
                info.changed++;
            } else if (!userMap.containsKey(users.id)) {
                info.deleted++;
            }
        }
        sumDeleted += info.deleted;
        info.added = userMap.size() + sumDeleted - previous.size();
        return info;
    }

    public static void main(String[] args) {
        Analize analize = new Analize();
        List<User> previous = new ArrayList<>();
        previous.add(new User(1, "Вася"));
        previous.add(new User(2, "Коля"));
        previous.add(new User(3, "Толя"));
        previous.add(new User(4, "Дима"));
        previous.add(new User(5, "Саша"));
        System.out.println(analize.diff(previous, previous));
    }
}
