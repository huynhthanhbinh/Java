package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DemoStream {
    public static void main(String[] args) {
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
                        .map(x->x*x)
                        .collect(Collectors.toList()))
                .forEach(System.out::println);

        arr.stream()
                .flatMap(a -> a.stream()
                        .map(x->x*x)).unordered()
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
                .generate(()->"element")
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
        s.mapToObj(i -> Character.toString((char) i)).forEach(System.out::print);
    }
}
