package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest  {

    @Test
    public void testAdd() {
        SimpleArray<Object> simpleArray = new SimpleArray(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        Object[] objects = new Object[]{"java", "C#", "C++", null, null};
        assertThat(simpleArray.getArray(), is(objects));
    }
    @Test
    public void testSet() {
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        simpleArray.set(2, "javaScript");
        assertThat(simpleArray.get(2), is("javaScript"));
    }
    @Test
    public void testRemove() {
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is("C++"));
    }
    @Test
    public void testGet() {
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        assertThat(simpleArray.get(0), is("java"));
    }
    @Test
    public void testIterator() {
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[2]);
        assertThat(simpleArray.iterator().hasNext(), is(false));
    }

    @Test
    public void testIterator2() {
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[0]);
        assertThat(simpleArray.iterator().hasNext(), is(false));
    }
    @Test
    public void testIterator3() {
        SimpleArray<Object> simpleArray = new SimpleArray<>();
        assertThat(simpleArray.iterator().hasNext(), is(false));
    }
}