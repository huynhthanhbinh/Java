package bht.oop;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private Date birthday;

    public Person() {

    }

    public Person(Person p) {
        id = p.id;
        name = p.name;
        birthday = p.birthday;
    }

    public Person(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
