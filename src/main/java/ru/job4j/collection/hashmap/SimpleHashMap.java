package ru.job4j.collection.hashmap;

import java.util.*;

public class SimpleHashMap<K, V> implements Map<K, V> {

     private Node<K, V>[] table = new Node[16];
     private int size = 0;
     private int modCount = 0;
    static int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }
    private void resize(int size) {
        Node<K, V>[] tab = table;
        table = new Node[size * 2];
        for (Node<K, V> e : tab) {
            int hash = hash(e.key);
            int index = hash & (table.length - 1);
            table[index] = new Node<>(e.hash, e.key, e.value);
        }
    }
    @Override
    public boolean insert(K key, V value) {
        if (size == table.length) {
            resize(size);
        }
        int hash = hash(key);
        int index = hash & (table.length - 1);
        Node<K, V> e = table[index];
        if (e == null) {
            table[index] = new Node<>(hash(key), key, value);
            modCount++;
            size++;
            return true;
        } else if (e.hash == hash &&  (key != null && key.equals(e.key))) {
           table[index] = new Node<>(hash(key), key, value);
           modCount++;
           return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        Node<K, V> e;
        int hash = hash(key);
        int index = hash & (table.length - 1);
         e = table[index];
         if (e != null) {
             if (e.hash == hash && key == null || (key != null && key.equals(e.key))) {
                 return e.value;
             }
         }
        return null;
    }

    @Override
    public boolean delete(K key) {
        Node<K, V> e;
        int hash = hash(key);
        int index = hash & (table.length - 1);
        e = table[index];
        if (e != null) {
            if (e.hash == hash && (key != null && key.equals(e.key))) {
                table[index] = null;
                modCount++;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int expectedModCount = modCount;
            int i = 0;
            SimpleHashMap.Node<K, V> node = null;
            int index = 0;
            @Override
            public boolean hasNext() {
                if (i >= table.length) {
                    return false;
                }
                    node = table[i];
                    while (i < table.length) {
                        node = table[i];
                        if (node != null) {
                            return true;
                        } else if (node == null) {
                            i++;
                        }
                    }
                    return node != null;
            }
            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[i++].value;
            }
        };
    }
    private static class Node<K, V> {
        final int hash;
        final K key;
        final V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
