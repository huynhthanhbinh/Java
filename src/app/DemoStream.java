package app;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoStream {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(arr1);
        arr.add(arr2);

        arr.stream()
                .map(a -> a.stream()
                        .map(x -> x * x)
                        .collect(Collectors.toList()))
                .forEach(System.out::println);

        arr.stream()
                .flatMap(a -> a.stream()
                        .map(x -> x * x))
                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(System.out::println);

        System.out.println();

        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        streamBuilder.forEach(System.out::println);
        System.out.println();

        Stream<String> streamGenerate = Stream
                .generate(() -> "element")
                .limit(10);


        streamGenerate.forEach(System.out::println);
        System.out.println();

        Stream<Integer> streamIterated = Stream
                .iterate(10, n -> --n)
                .limit(5);
        streamIterated.forEach(System.out::println);
        System.out.println();


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a - b);

        System.out.println(reduced);

        String[] array = new String[]{"a", "b", "c"};
        Stream<String> streamOfArray = Stream.of(array);
        streamOfArray.forEach(System.out::println);

        System.out.println();
        IntStream s = "Richard Binh Huynh".chars();
        s.mapToObj(i -> Character.toString((char) i))
                .forEach(System.out::println);

        String sample = "Huynh, Thanh, Binh";
        Stream<String> splitStream = Pattern
                .compile(", ")
                .splitAsStream(sample);
        splitStream.forEach(System.out::println);


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

        first.ifPresent(System.out::println);
        any.ifPresent(System.out::println);
        System.out.println();

        Path path = Paths.get("companies.csv");
        Stream<String> lines = Files.lines(path).skip(1);
        lines.forEach(System.out::println);
    }
}
