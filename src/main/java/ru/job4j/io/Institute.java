package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Institute {
    private final Student student;
    private final String[] listOfFaculties;
    private final int numberOfStudents;
    private final boolean isHumanitarian;

    public Institute(Student student, int numberOfStudents, boolean isHumanitarian, String... listOfFaculties) {
        this.student = student;
        this.listOfFaculties = listOfFaculties;
        this.numberOfStudents = numberOfStudents;
        this.isHumanitarian = isHumanitarian;
    }

    @Override
    public String toString() {
        return "Institute{"
                + "student=" + student
                + ", listOfFaculties=" + Arrays.toString(listOfFaculties)
                + ", numberOfStudents=" + numberOfStudents
                + ", isHumanitarian=" + isHumanitarian
                + '}';
    }

    public static void main(String[] args) {
        Student student = new Student("Вася", 24);
        Institute institute = new Institute(student, 1235, false, "Информатика и вычислительная техника ", "Бизнес-информатика");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(institute));

        final String InstituteJSON = "{"
                + "\"student\":"
                + "{"
                + "\"name\": Федя,"
                +  "\"age\": 23 "
                + "},"
                + "\"isHumanitarian\": true,"
                + "\"numberOfStudents\": 1345,"
                + "\"listOfFaculties\":"
                + "[\"Информатика и вычислительная техника\",\"Бизнес-информатика\"]"
                + "}";

        final  Institute instituteMod = gson.fromJson(InstituteJSON, Institute.class);
        System.out.println(instituteMod);

    }
}
