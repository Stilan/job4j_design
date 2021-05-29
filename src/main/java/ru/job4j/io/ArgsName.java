package ru.job4j.io;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
            return values.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */
        try {
            if (args.length != 2) {
                throw new Exception();
            }
        for (int i = 0; i < args.length; i++) {
            String[] string = args[i].substring(1).split("=");
            values.put(string[0], string[1]);
        }
    } catch (Exception e) {
        throw new IllegalArgumentException();
    }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
