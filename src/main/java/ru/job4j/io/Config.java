package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (line.contains("#") || line.equals("")) {
                    continue;
                }
                    String[] strAr = line.split("=");
                   if (strAr.length != 2 || strAr[0].equals("")) {
                       throw new Exception();
                   }
                    values.put(strAr[0], strAr[1]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    public String value(String key) {
      //  throw new UnsupportedOperationException("Don't impl this method yet!");
            return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
