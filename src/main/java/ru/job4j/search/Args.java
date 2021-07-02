package ru.job4j.search;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private String[] args;
    Map<String, String> mapArgs = new HashMap<>();

    public Map<String, String> getMapArgs() {
        return mapArgs;
    }

    public Args(String[] args) {
        this.args = args;
        for (int i = 0; i < args.length; i++) {
            String[] string = args[i].substring(1).split("[=\\-]");
            for (int j = 0; j < string.length;  j += 2) {
                this.mapArgs.put(string[j], string[j + 1]);

            }
        }
    }

}
