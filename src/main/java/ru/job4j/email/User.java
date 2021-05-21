package ru.job4j.email;

import ru.job4j.collection.set.Set;

import java.util.Objects;

public class User {
    private String nameUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(nameUser, user.nameUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameUser);
    }

    public User(String nameUser) {
        this.nameUser = nameUser;
    }
}
