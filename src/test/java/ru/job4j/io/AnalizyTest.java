package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest  {
     @Rule
     public TemporaryFolder folder = new TemporaryFolder();
      @Test
     public void testAnalizy() throws IOException {
          File source =  folder.newFile("source.csv");
          File target =  folder.newFile("target.csv");
          try (PrintWriter printWriter = new PrintWriter(source)) {
              printWriter.println("200 10:56:01");
              printWriter.println("500 10:57:01");
              printWriter.println("400 10:58:01");
              printWriter.println("200 10:59:01");
              printWriter.println("500 11:01:02");
              printWriter.println("200 11:02:02");
          }
          Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
              StringBuilder out = new StringBuilder();
              try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
                  reader.lines().forEach(out::append);
              }
          assertThat(out.toString(), is("10:57:01;10:59:01;11:01:02;11:02:02;"));
          }
}