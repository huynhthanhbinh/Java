package app.stream;

import app.MyFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class DemoLazy {
    private static long counter;

    private static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoLazy.class);
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream = list.stream()
                .filter(element -> {
                    wasCalled();
                    logger.info("filter() was called");
                    return element.contains("2");
                });
        logger.info(String.valueOf(counter));

        Optional<String> first = stream
                .map(element -> {
                    logger.info("map() was called");
                    return element.toUpperCase();
                }).findFirst();
        logger.info(String.valueOf(counter));
        first.ifPresent(logger::info);
    }
}