package bht.exceptions;

import java.util.logging.Logger;

public class ExceptionLogger {
    public static void log(Logger logger, Exception e) {
        int n = e.getStackTrace().length;
        StackTraceElement x = e.getStackTrace()[n-1];
        logger.info("Exception is thrown at line: " + x.getLineNumber());
        logger.info("");
        logger.info("Method name: " + x.getMethodName());
        logger.info("Class name : " + x.getClassName());
        logger.info("File name  : " + x.getFileName());
        logger.info("Exception  : " + e.getMessage());
        logger.info("");
    }
}