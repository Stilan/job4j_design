package ru.job4j.io;

import org.json.JSONObject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.util.Arrays;

/**
 *
 * @author Litvinov Alexander
 * @version 1.0
 * @since 14.06.2021
 */

@XmlRootElement(name = "institute")
@XmlAccessorType(XmlAccessType.FIELD)
public class Institute {

    private  Student student;
    @XmlElementWrapper(name = "listOfFaculties")
    @XmlElement(name = "faculty")
    private  String[] listOfFaculties;
    @XmlAttribute
    private  int numberOfStudents;
    @XmlAttribute
    private  boolean isHumanitarian;
    public Institute() {
    }

    public Student getStudent() {
        return student;
    }

    public String[] getListOfFaculties() {
        return listOfFaculties;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public boolean isHumanitarian() {
        return isHumanitarian;
    }

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

    public static void main(String[] args) throws JAXBException {
        Student student = new Student("Вася", 24);
        Institute institute = new Institute(student, 1235, false, "Информатика и вычислительная техника ", "Бизнес-информатика");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("numberOfStudents", institute.getNumberOfStudents());
        jsonObject.put("isHumanitarian", institute.isHumanitarian());
        jsonObject.put("student", institute.getStudent());
        jsonObject.put("listOfFaculties", institute.getListOfFaculties());

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(institute).toString());

    }
}
