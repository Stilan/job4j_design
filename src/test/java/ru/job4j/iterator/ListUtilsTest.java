package ru.job4j.iterator;

import junit.framework.TestCase;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }
    @Test
    public void whenAddAfterLast2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
        ListUtils.removeIf(input, x -> x > 1);
        assertThat(Arrays.asList(0, 1), Is.is(input));
        ListUtils.replaceIf(input, x -> x == 0, 2);
        assertThat(Arrays.asList(2, 1), Is.is(input));
        List<Integer> elements = new ArrayList<>(Arrays.asList(3, 4, 2));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1), Is.is(input));
    }
}