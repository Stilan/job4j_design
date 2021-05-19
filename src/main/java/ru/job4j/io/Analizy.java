package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean inactive = false;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                for (String line = read.readLine(); line != null; line = read.readLine()) {
                    String[] strings = line.split(" ");
                    int status = Integer.parseInt(strings[0]);
                    String date = strings[1];
                    if (status == 500 || status == 400) {
                        if (!inactive) {
                            out.print(date + ";");
                            inactive = true;
                        }
                    } else {
                        if (inactive) {
                            out.print(date + ";");
                            inactive = false;
                            out.println();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
