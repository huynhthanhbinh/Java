package app.stream;

import app.MyFormatter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DemoFlatMap {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoFlatMap.class);
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
                .forEach(x->logger.info(String.valueOf(x)));

        logger.info("");

        arr.stream()
                .flatMap(a -> a.stream()
                        .map(x -> x * x))
                .collect(Collectors.toCollection(LinkedList::new))
                .forEach(x->logger.info(String.valueOf(x)));
    }
}
