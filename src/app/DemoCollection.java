package app;


import bht.oop.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Spliterator;
import java.util.logging.Logger;

public class DemoCollection {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoCollection.class);

        Collection<Person> people = new ArrayList<>();
        people.add(new Person("Jack"));
        people.add(new Person("Jane"));
        people.add(new Person("Jasmine"));
        people.add(new Person("Joe"));
        people.add(new Person("John"));
        people.add(new Person("Julie"));
        people.add(new Person("Jerry"));
        people.add(new Person("Jim"));

        for (Person person : people) {
            logger.info("Hello " + person.getName());
        }

        Spliterator<Person> peopleSpliterator = people.spliterator();
        logger.info("" + peopleSpliterator.characteristics());
        logger.info("" + peopleSpliterator.estimateSize());

        Spliterator<Person> newPartition = peopleSpliterator.trySplit();


        logger.info("" + newPartition.estimateSize());
        logger.info("" + peopleSpliterator.estimateSize());

        for (Person person : people) {
            logger.info("Hello " + person.getName());
        }
    }
}
