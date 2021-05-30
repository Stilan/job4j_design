package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
      if (values.size() == 0) {
          throw new IllegalArgumentException();
      }
            return values.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */
        for (int i = 0; i < args.length; i++) {
            String[] string = args[i].substring(1).split("=");
            if (!args[i].startsWith("-") || string.length != 2 || string[0].isEmpty() || string[1].isEmpty()) {
                throw new IllegalArgumentException();
            }
                values.put(string[0], string[1]);
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
