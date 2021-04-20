package ru.job4j.tree;


import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }
    @Override
    public boolean isBinary() {
        Predicate<Node<E>> condition = i -> i.children.size() > 2;
        if (findByPredicate(condition).isEmpty()) {
            return true;
        }
        return false;
    }
    @Override
    public Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (!findBy(child).isPresent()) {
            Optional<Node<E>> optionalENode = findBy(parent);
            if (optionalENode.isPresent()) {
                Node<E> node = optionalENode.get();
                node.children.add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
    }
    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> condition = i -> i.value.equals(value);
        return findByPredicate(condition);

    }

}
