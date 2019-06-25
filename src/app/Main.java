package app;

import bht_exception.ExceptionLogger;
import bht_exception.FileNotExistException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Huynh Thanh Binh (BHT) - ELCA
 */

public class Main {
    public static void main(String... args) {
        Logger logger = MyFormatter.reformatLogger(Main.class);
        String fileName = "";

        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                logger.info(file.nextLine());
            }
        } catch (FileNotFoundException e) {
            if (!FileNotExistException.isCorrectFilename(fileName)) {
                try {
                    throw new FileNotExistException("(" + fileName + ") file is not exist", e);
                } catch (FileNotExistException ex) {
                    logger.info("Exception is caught at line: " + e.getStackTrace()[e.getStackTrace().length - 1].getLineNumber());
                    ExceptionLogger.log(logger, ex);
                }
            }
        } catch (Exception e) {
            ExceptionLogger.log(logger, e);
        } finally {
            logger.info("Reach finally block");
        }
    }
}