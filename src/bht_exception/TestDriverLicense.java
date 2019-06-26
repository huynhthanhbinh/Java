package bht_exception;

import app.MyFormatter;

import java.util.logging.Logger;

public class TestDriverLicense {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(TestDriverLicense.class);
        DriverLicense driverLicense = new DriverLicense("Phat", 17);
        logger.info(driverLicense.toString());
    }
}
