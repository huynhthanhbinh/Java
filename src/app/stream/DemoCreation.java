package app.stream;

import app.MyFormatter;

import java.util.logging.Logger;
import java.util.stream.Stream;

public class DemoCreation {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoCreation.class);

        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        streamBuilder.forEach(logger::info);
        logger.info("");

        Stream<String> streamGenerate = Stream
                .generate(() -> "element")
                .limit(10);

        streamGenerate.forEach(logger::info);
        logger.info("");

        Stream<Integer> streamIterated = Stream
                .iterate(10, n -> --n)
                .limit(5);
        streamIterated.forEach(x->logger.info(String.valueOf(x)));
        logger.info("");

        String[] array = new String[]{"a", "b", "c"};
        Stream<String> streamOfArray = Stream.of(array);
        streamOfArray.forEach(logger::info);
    }
}
