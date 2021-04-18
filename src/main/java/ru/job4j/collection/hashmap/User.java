package ru.job4j.collection.hashmap;

import java.util.*;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + Integer.hashCode(children);
        result = 31 * result + (birthday == null ? 0 : birthday.hashCode());
        return result;
    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, children, birthday);
//    }

    public static void main(String[] args) {
        User user1 = new User("Вася", 2, new GregorianCalendar(1991, Calendar.DECEMBER, 1));
        User user2 = new User("Федя", 2, new GregorianCalendar(1990, Calendar.JULY, 3));
        Map<User, Object> map = new HashMap<>();
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        map.put(user1, new Object());
        map.put(user2, new Object());
    }
}