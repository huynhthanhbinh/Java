package app;

import java.util.logging.Logger;

/**
 * @author Huynh Thanh Binh (BHT) - ELCA
 */

public class Main {
    public static void main(String... args) {
        Logger logger = MyFormatter.reformatLogger(Main.class);

        if (false)
            throw new ArithmeticException("divide by zero ");

        try {
            String str = null;
            logger.info("\ntry block caught");
            logger.info(String.valueOf(str.length()));
        } catch (NullPointerException e) {
            logger.info("\nException: " + e.toString());
        } catch (Exception e) {
            logger.info("\nOther exceptions");
        } finally {
            logger.info("\nfinally block caught");
        }
        logger.info("\nOut of exceptions caught !");
    }
}