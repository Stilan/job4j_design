package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.contains("404")) {
                    stringList.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringList;
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String s:log) {
            System.out.println(s);
        }

    }
}
