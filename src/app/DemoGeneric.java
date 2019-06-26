package app;

import bht.generic.Template;

import java.util.logging.Logger;

public class DemoGeneric {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoGeneric.class);

        Integer[] ints = {10, 80, 30, 40, 50};
        Character[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        String[] strings = {"Dinh Kha", "Duc Hai", "Huu Bao", "Truong Thanh", "Minh Dang", "Thanh Hai", "Viet Luc"};

        Template.printArray(ints);
        Template.printArray(chars);
        Template.printArray(strings);

        logger.info(Template.findMax(ints).toString());
    }
}
