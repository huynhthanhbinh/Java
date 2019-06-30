package app.stream;

import app.MyFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class DemoReduction {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoReduction.class);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer reduced = integers.stream()
                .reduce(23, (a, b) -> a - b);

        logger.info(String.valueOf(reduced));
    }
}
