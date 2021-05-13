package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.contains("404")) {
                    stringList.add(line + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringList;
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
