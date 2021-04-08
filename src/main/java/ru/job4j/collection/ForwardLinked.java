package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        if (head != null && head.next != null) {
           Node<T> previous = null;
           Node<T> current = head;
           while (current != null) {
               Node<T> following = current.next;
               current.next = previous;
               previous = current;
               current = following;
           }
           head = previous;
              return true;
        }
        return false;
    }

    public void addFist(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = node;
        tail.next = head;
        head = tail;
    }
    public T deleteFirst() {
       Node<T> node = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        return node.value;
    }

    public T deleteLast() {
        Node<T> node = head;
        if (head.next == null) {
            head = null;
        } else {
            head.next = null;
        }
        return node.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
