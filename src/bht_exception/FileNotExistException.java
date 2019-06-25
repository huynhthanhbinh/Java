package bht_exception;

import java.io.File;
import java.io.IOException;

public class FileNotExistException extends IOException {
    public FileNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public static boolean isCorrectFilename(String filename) {
        File file = new File(filename);
        if (file.exists()) return true;
        return false;
    }
}