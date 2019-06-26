package bht.wildcards;

import java.util.List;

public class Building {
    private String address;

    public Building(String address) {
        if (address != null) {
            setAddress(address);
        }
    }

    //public static void paintAllBuildings(List<Building> buildings) { : Error Compile !
    public static void paintAllBuildings(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return getClass().getName() + " | " + getAddress();
    }

    public void paint() {
        System.out.println("painted the building");
    }
}
