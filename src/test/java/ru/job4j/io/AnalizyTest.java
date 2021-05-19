package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest  {
      @Test
     public void testAnalizy(){
          Analizy analizy = new Analizy();
          analizy.unavailable("source.csv", "target.csv");
          StringBuilder out = new StringBuilder();
          try (BufferedReader read = new BufferedReader(new FileReader("target.csv"))) {
              for (String line = read.readLine(); line != null; line = read.readLine()) {
                  out.append(line);
              }
          } catch (Exception e){
              e.printStackTrace();
          }
          assertThat(out.toString(), is("10:57:01;10:59:01;11:01:02;11:02:02;"));
      }
}