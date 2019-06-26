package app;

import bht.exceptions.DriverLicense;

import java.util.logging.Logger;

public class DemoDriverLicense {
    public static void main(String[] args) {
        Logger logger = MyFormatter.reformatLogger(DemoDriverLicense.class);
        DriverLicense driverLicense = new DriverLicense("Phat", 17);
        logger.info(driverLicense.toString());
    }
}
