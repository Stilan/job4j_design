package ru.job4j.io;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}
