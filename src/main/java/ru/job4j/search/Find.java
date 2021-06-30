package ru.job4j.search;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Find extends SimpleFileVisitor<Path> {

    private Predicate<Path> condition;
    private List<Path> paths = new ArrayList<>();

    public List<Path> getPaths() {
        return paths;
    }

    public Find(Predicate<Path> condition) {
        this.condition = condition;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (condition.test(file)) {
            this.paths.add(file);
        }
        return CONTINUE;
    }
}
