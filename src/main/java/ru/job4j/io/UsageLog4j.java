package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Иван";
        String surname = "Иванов";
        String position = "Студент";
        int course = 2;
        String specialty = "Программист";
        double averageScore = 4.1;
        long gradeBookNumber = 234565651;
        int age = 31;

        LOG.debug("имя :{} \n фамилия :{}\n профессия :{}\n курс :{}\n специальность :{}\n "
                        + "средний балл :{}\n номер зачетки :{}\n возрост :{}", name, surname, position, course,
                        specialty, averageScore, gradeBookNumber, age);
    }
}
