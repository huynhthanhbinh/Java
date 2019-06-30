package app.stream;

import app.MyFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class DemoFile {
    public static void main(String[] args) throws IOException {
        Logger logger = MyFormatter.reformatLogger(DemoFile.class);
        Path path = Paths.get("companies.csv");
        Stream<String> lines = Files.lines(path).skip(1);
        lines.forEach(logger::info);
    }
}
