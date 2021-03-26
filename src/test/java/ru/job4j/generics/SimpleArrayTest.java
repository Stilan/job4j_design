package ru.job4j.generics;


import org.junit.Test;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest  {

    @Test
    public void TestAdd(){
        SimpleArray<Object> simpleArray = new SimpleArray(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        Object[] objects = new Object[]{"java","C#","C++",null,null};
        assertThat(simpleArray.getArray(),is(objects));
    }
    @Test
    public void TestSet(){
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        simpleArray.set(2,"javaScript");
        assertThat(simpleArray.get(2),is("javaScript"));
    }
    @Test
    public void TestRemove(){
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1),is("C++"));
    }
    @Test
    public void TestGet(){
        SimpleArray<Object> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add("java");
        simpleArray.add("C#");
        simpleArray.add("C++");
        assertThat(simpleArray.get(0),is("java"));
    }
}