package ru.job4j.io;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

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

        JAXBContext context = JAXBContext.newInstance(Institute.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(institute, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Institute result = (Institute) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
