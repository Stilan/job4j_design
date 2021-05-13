package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("even.txt")) {
            int read = 0;
            StringBuilder text = new StringBuilder();
            while ((read = fileInputStream.read()) != -1) {
                text.append((char) read);
            }
            String[] str = text.toString().split("\n");
            for (String line : str) {
                int num = Integer.parseInt(line);
                boolean rsl = num % 2 == 0;
                System.out.println(num + " " + rsl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
