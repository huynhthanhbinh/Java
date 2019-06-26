package bht.generic;

import java.util.function.Function;
import java.util.logging.Logger;

public class Template {
    private Template() {

    }

    public static <T> void printArray(T[] objects) {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement x = stack[stack.length - 1];
        Logger logger = Logger.getLogger(x.getClassName());

        for (T obj : objects) {
            logger.info(obj.toString());
        }
        logger.info("");
    }

    public static <T extends Number & Comparable <T>> T findMax(T[] arr) {
        T max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
}
