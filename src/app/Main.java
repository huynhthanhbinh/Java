package app;

import java.util.logging.Logger;

/**
 * @author Huynh Thanh Binh (BHT) - ELCA
 */

public class Main {
    public static void main(String... args) {
        Logger logger = MyFormatter.reformatLogger(Main.class);

        try {
            String str = "Binh";
            logger.info("\ntry block caught");
            logger.info(String.valueOf(str.length()));
        } catch (Exception e) {
            logger.info("\ncatch block caught");
            logger.info(e.toString());
        } finally {
            logger.info("\nfinally block caught");
        }
        logger.info("\nOut of exceptions caught !");
    }
}