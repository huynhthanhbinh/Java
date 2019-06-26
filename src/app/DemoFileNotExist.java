package app;

import bht.exceptions.ExceptionLogger;
import bht.exceptions.FileNotExistException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class DemoFileNotExist {
    public static void main(String... args) {
        Logger logger = MyFormatter.reformatLogger(DemoMain.class);
        String input = "src/app/DemoMain";
        String output = "test.txt";

        try (Scanner scanner = new Scanner(new File(input));
             PrintWriter writer = new PrintWriter(new File(output))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.println(line);
                logger.info(line);
            }
        } catch (FileNotFoundException e) {
            if (!FileNotExistException.isCorrectFilename(input)) {
                try {
                    throw new FileNotExistException("(" + input + ") file is not exist", e);
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
