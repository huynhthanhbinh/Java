package bht_interface;

public class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks \"Woof-Woof\"");
    }

    @Override
    public void run() {
        System.out.println("The dog is running !");
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int val) {
        //x = val;
    }

    @Override
    public void walk() {
        System.out.println("The dog is walking !");
    }

    @Override
    public void jump() {
        System.out.println("The dog is jumping !");
    }

    @Override
    public void eat() {
        System.out.println("The dog is eating !");
    }

    @Override
    public void drink() {
        System.out.println("The dog is drinking");
    }
}
