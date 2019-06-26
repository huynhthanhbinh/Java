package bht_exception;

public class DriverLicense {
    private String name;
    private int age;

    public DriverLicense(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18 !");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "] Name: " + getName() + " | Age: " + getAge();
    }
}
