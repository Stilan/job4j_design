package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Вася", 2, new GregorianCalendar(1990, Calendar.JANUARY, 25));
        User user2 = new User("Федя", 2, new GregorianCalendar(1987, Calendar.DECEMBER, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, user1);
        map.put(user2, user2);
        System.out.println(map);
//        5.1. Объекты попали в один бакет или в разные?
//        5.2. Вызывался ли в этом случае equals() у объектов User или нет? Объяснить почему
    }
}
