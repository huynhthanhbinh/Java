package app;

import bht.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * @author Huynh Thanh Binh (BHT) - ELCA
 */

public class Main {
    public static void main(String ... args) {
        Logger logger = MyFormatter.reformatLogger(Main.class);

        logger.info("Unsorted");
        Student[] arrStudent = {
                new Student(1653006, "Huynh Thanh Binh", "Binh Chanh"),
                new Student(1653011, "Vu Minh Dang", "Go Vap"),
                new Student(1653005, "Vu Tuong Bach", "Binh Thanh"),
                new Student(1653020, "Vu Hai", "Binh Chanh"),
                new Student(1653018, "Phan Tran The Duy", "Binh Thanh")
        };
        Student[] origin = arrStudent.clone();

        for (Student s : arrStudent) {
            logger.info(s.toString());
        }

        logger.info("\nSort by ID:");
        Arrays.sort(arrStudent, Student.BY_ID);
        for (Student s : arrStudent) {
            logger.info(s.toString());
        }

        logger.info("\nSort by Name:");
        Arrays.sort(arrStudent, Student.BY_NAME);
        for (Student s : arrStudent) {
            logger.info(s.toString());
        }

        logger.info("\nSort by Address:");
        Arrays.sort(arrStudent, Student.BY_ADDRESS);
        for (Student s : arrStudent) {
            logger.info(s.toString());
        }

        logger.info("\nCurrent:");
        for (Student s : arrStudent) {
            logger.info(s.toString());
        }

        logger.info("\nOrigin:");
        for (Student s : origin) {
            logger.info(s.toString());
        }

        ArrayList<Student> myArr = new ArrayList<>(Arrays.asList(arrStudent));
        Collections.sort(myArr);

        logger.info("\nSort by ID:");
        for (Student s : myArr) {
            logger.info(s.toString());
        }
    }
}