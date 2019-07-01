package bht;

import java.util.Comparator;
import java.util.logging.Logger;

public class Company {
    public static final Comparator<Company> BY_CAPITAL_DESC = new ByCapitalDesc();
    private int id;
    private String name;
    private String foundation;
    private int capital;
    private String country;
    private String headquarterID;

    public static Company toCompany(String line) {
        String[] fields = line.split(",");
        if (fields.length >= 5) {
            Company c = new Company();

            c.id = Integer.parseInt(fields[0]);
            c.name = fields[1];
            c.foundation = fields[2];
            c.capital = Integer.parseInt(fields[3]);
            c.country = fields[4];
            c.headquarterID = (fields.length == 6) ? fields[5] : "";

            return c;
        }
        return null;
    }

    public static void log(Company c) {
        StackTraceElement[] x = Thread.currentThread().getStackTrace();
        int n = x.length;
        StackTraceElement current = x[n-1];

        Logger logger = Logger.getLogger(current.getClassName());
        logger.info(c.toString());
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String
                .format("%,8d | %-25s | %-10s | %,8d | %-2s | %-5s",
                        this.id,
                        this.name,
                        this.foundation,
                        this.capital,
                        this.country,
                        this.headquarterID);
    }

    private static class ByCapitalDesc implements Comparator<Company> {
        @Override
        public int compare(Company o1, Company o2) {
            return o2.capital - o1.capital;
        }
    }
}
