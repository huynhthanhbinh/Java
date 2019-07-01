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
        List<Company> companies = Files.lines(path)
                .skip(1)
                .map(Company::toCompany)
                .collect(Collectors.toList());


        logger.info("Get list of Companies from CSV file\n");
        companies.forEach(Company::log);


        logger.info("\nList sorted by country\n");
        companies.stream()
                .sorted(Company.BY_COUNTRY_ASC)
                .forEach(Company::log);


        logger.info("\nList sorted by country then capital\n");
        companies.stream()
                .sorted(Company.BY_COUNTRY_THEN_CAPITAL)
                .forEach(Company::log);


        logger.info("\nFilter on Country by CH, sorted by Capital descending order\n");
        companies.stream()
                .filter(company -> company.getCountry().equals("CH"))
                .sorted(Company.BY_CAPITAL_DESC)
                .forEach(Company::log);


        logger.info("\nAll companies in CH\n");
        companies.stream()
                .filter(company -> company.getCountry().equals("CH"))
                .map(Company::getName)
                .forEach(logger::info);
    }
}
