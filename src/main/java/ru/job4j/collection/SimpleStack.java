package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    public int size;
    public T pop() {
        size--;
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFist(value);
        size++;
    }
    public boolean sizeStack() {
        return size == 0;
    }
}
