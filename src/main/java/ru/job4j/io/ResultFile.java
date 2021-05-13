package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream("result.txt")))) {
            int[][] table = multiple(10);
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                      out.write(String.valueOf(table[i][j]) + "\t");
                }
                out.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
