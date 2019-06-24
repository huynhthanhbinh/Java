package bht_interface;

public class Corgi extends Dog {
    @Override
    public void walk() {
        System.out.println("Corgi is walking");
    }

    @Override
    public void run() {
        System.out.println("Corgi is running");
    }

    @Override
    public void jump() {
        System.out.println("Corgi is jumping");
    }
}
