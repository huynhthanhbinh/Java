package app.stream;

import app.MyFormatter;
import bht.Company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DemoFile {
    public static void main(String[] args) throws IOException {
        Logger logger = MyFormatter.reformatLogger(DemoFile.class);
        Path path = Paths.get("companies.csv");
        List<String> lines = Files.lines(path).skip(1).collect(Collectors.toList());

        logger.info("Get list of Companies from CSV file");
        logger.info("");

        lines.stream()
                .map(Company::toCompany)
                .forEach(Company::log);

        logger.info("");
        logger.info("Filter on Country by CH, sorted by Capital descending order");
        logger.info("");

        lines.stream()
                .map(Company::toCompany)
                .filter(company -> company.getCountry().equals("CH"))
                .sorted(Company.BY_CAPITAL_DESC)
                .forEach(Company::log);
    }
}
