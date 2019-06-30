package app.stream;

import app.MyFormatter;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoReference {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoReference.class);
//        Stream<String> stream = Stream
//                .of("a", "ba", "bb", "bc", "c")
//                .filter(element -> element.contains("b"));
//        Optional<String> firstElement = stream.findFirst();
//        firstElement.ifPresent(System.out::println);
//        Optional<String> anyElement = stream.findAny();
//        anyElement.ifPresent(System.out::println);

        List<String> elements = Stream
                .of("a", "ba", "bb", "bc", "c")
                .skip(2)
                .filter(element -> element.contains("b"))
                .collect(Collectors.toList());
        Optional<String> any = elements.stream().findAny();
        Optional<String> first = elements.stream().findFirst();

        first.ifPresent(logger::info);
        any.ifPresent(logger::info);
    }
}
