package app;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class MyFormatter extends Formatter {
    public static final Logger reformatLogger(Class main) {
        Logger logger = Logger.getLogger(main.getName());
        MyFormatter myFormatter = new MyFormatter();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(myFormatter);

        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.INFO);
        return logger;
    }

    @Override
    public String format(LogRecord record) {
        return formatMessage(record) + "\n";
    }
}