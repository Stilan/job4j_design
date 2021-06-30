package ru.job4j.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FindFiles {
    public static List<Path> search(Path root, Args args) throws IOException {
         Find fiveVisitor = filter(args);
         Files.walkFileTree(root, fiveVisitor);
         return fiveVisitor.getPaths();
    }

    public static Find filter(Args args) {
        Find find = null;
        if (args.getType().equals("mask")) {
            find = new Find(path -> path.toFile().getName().endsWith(args.getName()));
        } else if (args.getType().equals("name")) {
            find = new Find(path -> path.toFile().getName().equals(args.getName()));
        } else if (args.getType().equals("regex")) {
            find = new Find(path -> path.toFile().getName().startsWith(args.getName()));
        }
        return find;
    }

    public static void write(String output, List<Path> paths) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            for (Path path : paths) {
                bw.write(String.valueOf(path + System.lineSeparator()));
                bw.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
      //  Args arg = new Args(new String[]{"-d=/Users/aleksandrlitvinov/Desktop/TestJob4j-n=Без названия.txt-t=name-o=log.txt"});
        Args arg = new Args(args);
        List<Path> result = search(Paths.get(arg.getDirectory()), arg);
        write(arg.getOutput(), result);
    }
}
