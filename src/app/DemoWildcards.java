package app;

import bht.wildcards.Building;
import bht.wildcards.Cottage;
import bht.wildcards.House;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoWildcards {
    public static void main(String[] args) {
        MyFormatter.reformatLogger(DemoWildcards.class);

        House[] arrHouse = new House[8];
        Cottage[] arrCottage = new Cottage[10];

        for (int i = 0; i < arrHouse.length; i++) {
            arrHouse[i] = new House("123 ABC /" + (i + 1));
        }
        for (int i = 0; i < arrCottage.length; i++) {
            arrCottage[i] = new Cottage("456 DEF /" + (i + 1));
        }

        List<House> listHouse = new ArrayList<>(Arrays.asList(arrHouse).subList(0, 8));
        List<Cottage> listCottage = new ArrayList<>(Arrays.asList(arrCottage).subList(0, 9));

        Building.paintAllBuildings(listHouse);
        Building.paintAllBuildings(listCottage);
    }
}
