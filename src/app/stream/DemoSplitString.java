package app.stream;

import app.MyFormatter;

import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoSplitString {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoSplitString.class);
        IntStream s = "Richard Binh Huynh".chars();
        s.mapToObj(i -> Character.toString((char) i))
                .forEach(logger::info);

        logger.info("");

        String sample = "Huynh, Thanh, Binh";
        Stream<String> splitStream = Pattern
                .compile(", ")
                .splitAsStream(sample);
        splitStream.forEach(logger::info);
    }
}
