package ru.job4j;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;

public class AnalizeTest  {

    @Test
   public void diffTestDeleted() {
        Analize analize = new Analize();
        List<User> previous = new ArrayList<>();
        previous.add(new User(1, "Вася"));
        previous.add(new User(2, "Коля"));
        previous.add(new User(3, "Толя"));
        previous.add(new User(4, "Дима"));
        previous.add(new User(5, "Саша"));
        List<User> current = new ArrayList<>();
        Info info = new Info();
        info.added = 0;
        info.changed = 0;
        info.deleted = 5;
         assertThat(analize.diff(previous, current), is(info));
         previous = new ArrayList<>(current);
         current.add(new User(1, "Вася"));
         current.add(new User(2, "Коля"));
         current.add(new User(3, "Толя"));
         current.add(new User(4, "Дима"));
         current.add(new User(5, "Вася"));
         current.add(new User(6, "Коля"));
         current.add(new User(7, "Толя"));
         current.add(new User(8, "Дима"));
         current.add(new User(9, "Вася"));
         current.add(new User(10, "Коля"));
         info.added = 10;
         info.changed = 0;
         info.deleted = 0;
         assertThat(analize.diff(previous, current), is(info));
    }
     @Test
     public void diffTestChanged() {
          Analize analize = new Analize();
          List<User> previous = new ArrayList<>();
          previous.add(new User(1, "Вася"));
          previous.add(new User(2, "Коля"));
          previous.add(new User(3, "Толя"));
          previous.add(new User(4, "Дима"));
          previous.add(new User(5, "Саша"));
          List<User> current = new ArrayList<>();
          current.add(new User(1, "Коля"));
          current.add(new User(2, "Вася"));
          current.add(new User(3, "Толя"));
          current.add(new User(4, "Дима"));
          current.add(new User(5, "Даша"));
          Info info = new Info();
          info.added = 0;
          info.changed = 3;
          info.deleted = 0;
          assertThat(analize.diff(previous, current), is(info));
     }
     @Test
     public void diffTestAdded() {
          Analize analize = new Analize();
          List<User> previous = new ArrayList<>();
          previous.add(new User(1, "Вася"));
          previous.add(new User(2, "Коля"));
          previous.add(new User(3, "Толя"));
          previous.add(new User(4, "Дима"));
          previous.add(new User(5, "Саша"));
          List<User> current = new ArrayList<>();
          current.add(new User(1, "Коля"));
          current.add(new User(2, "Вася"));
          current.add(new User(3, "Толя"));
          current.add(new User(4, "Дима"));
          current.add(new User(5, "Саша"));
          current.add(new User(6, "Зоя"));
       //   current.add(new User(6,"Зоя"));
          Info info = new Info();
          info.added = 1;
          info.changed = 2;
          info.deleted = 0;
          assertThat(analize.diff(previous, current), is(info));
     }
}