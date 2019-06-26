package bht.wildcards;

public class House extends Building {
    public House(String address) {
        super(address);
    }

    @Override
    public void paint() {
        System.out.println("painted the house ! " + getAddress());
    }
}
