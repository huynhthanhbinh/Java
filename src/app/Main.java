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
        String fileName = "src/app/Main";

        try (Scanner file = new Scanner(new File(fileName))) {
            while (file.hasNextLine()) {
                logger.info(file.nextLine());
            }
        } catch (FileNotFoundException e) {
            if (!FileNotExistException.isCorrectFilename(fileName)) {
                try {
                    throw new FileNotExistException("(" + fileName + ") file is not exist", e);
                } catch (FileNotExistException ex) {
                    int lineNumber = e.getStackTrace()[e.getStackTrace().length - 1].getLineNumber();
                    logger.info("Exception is caught at line: " + lineNumber);
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