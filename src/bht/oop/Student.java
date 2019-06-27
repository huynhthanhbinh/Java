package bht.oop;

import java.util.Comparator;

public class Student extends Person implements Comparable<Student> {
    public static final Comparator<Student> BY_ID = new ById();
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_ADDRESS = new ByAddress();

    private int studentID;
    private String address;

    public Student(String name) {
        super(name);
    }

    public Student(Student s) {
        studentID = s.studentID;
        setName(s.getName());
        setAddress(s.getAddress());
    }

    public Student(int id, String name, String address) {
        this.studentID = id;
        this.setName(name);
        this.setAddress(address);
    }

    public static Comparator<Student> compareId() {
        return Comparator.comparingInt(o -> o.studentID);
    }

    public static Comparator<Student> compareName() {
        return Comparator.comparing(o -> o.getName().substring(o.getName().lastIndexOf(' ')));
    }

    public static Comparator<Student> compareAddress() {
        return Comparator.comparing(Student::getAddress);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int id) {
        this.studentID = id;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "] " + studentID + " - " + getName() + " - " + getAddress();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return studentID == student.studentID
                && getName().equals(student.getName())
                && getAddress().equals(student.getAddress());
    }

    @Override
    public int hashCode() {
        return studentID + getName().hashCode() + address.hashCode();
    }

    @Override
    public int compareTo(Student o) {
        return studentID - o.studentID;
    }

    private static class ById implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.studentID - o2.studentID;
        }
    }

    private static class ByName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            String name1 = o1.getName().substring(o1.getName().lastIndexOf(' '));
            String name2 = o2.getName().substring(o2.getName().lastIndexOf(' '));
            return name1.compareTo(name2);
        }
    }

    private static class ByAddress implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAddress().compareTo(o2.getAddress());
        }
    }
}


