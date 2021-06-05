package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            boolean isRespond = true;
            while (!str.equals(OUT)) {
                if (str.equals(STOP)) {
                     isRespond = false;
                }
                if (str.equals(CONTINUE)) {
                    isRespond = true;
                }
                if (isRespond) {
                    String str2 = programResponse(path);
                    System.out.println(str2);
                    writeToFile(botAnswers, str2);
                }
                writeToFile(botAnswers, str);
                str = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String programResponse(String path) {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            lines = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        int i = random.nextInt(lines.size());
         return lines.get(i);
    }
    public static void writeToFile(String path, String str) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(
                "/Users/aleksandrlitvinov/projects/job4j_design/src/main/java/ru/job4j/io/text.txt",
                "/Users/aleksandrlitvinov/projects/job4j_design/src/main/java/ru/job4j/io/text2.txt");
        cc.run();
    }
}
