package ru.job4j.email;

import java.util.Objects;

public class Email {
   private String emailUser;

    public Email(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(emailUser, email.emailUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailUser);
    }
}
