package ru.job4j;

import java.util.Objects;

public class Info {
    int added;
    int changed;
    int deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return added == info.added && changed == info.changed && deleted == info.deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(added, changed, deleted);
    }

    @Override
    public String toString() {
        return "Info{"
                + "added=" + added
                + ", changed=" + changed
                + ", deleted=" + deleted
                + '}';
    }
}
