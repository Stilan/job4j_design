package ru.job4j.collection.hashMap;

import org.w3c.dom.Node;
import ru.job4j.collection.SimpleLinkedList;

import java.util.HashMap;
import java.util.Iterator;

public class SimpleHashMap<K, V> implements Map<K, V> {

     private Node<K, V>[] table = new Node[16];
     private int size = 0;

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    @Override
    public boolean insert(K key, V value) {
        int hash = hash(key);
        int index = hash & (table.length - 1);
        Node<K, V> e = table[index];
        if (e == null) {
            table[index] = new Node<>(hash(key), key, value);
            size++;
            return true;
        } else if (e.hash == hash && e.key == null || (key != null && key.equals(e.key))) {
           table[index] = new Node<>(hash(key), key, value);
           size++;
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
        if (e.hash == hash && e.key == null || (key != null && key.equals(e.key))) {
                return e.value;
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        Node<K, V> e;
        int hash = hash(key);
        int index = hash & (table.length - 1);
        e = table[index];
        if (e.hash == hash && e.key == null || (key != null && key.equals(e.key))) {
            table[index] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
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
