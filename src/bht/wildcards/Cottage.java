package bht.wildcards;

public class Cottage extends Building {
    public Cottage(String address) {
        super(address);
    }

    @Override
    public void paint() {
        System.out.println("painted the cottage " + getAddress());
    }
}
