package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.sizeStack()) {
            while (!in.sizeStack()) {
                out.push(in.pop());
            }
        }
        if (!out.sizeStack()) {
            return out.pop();
        }
          return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
