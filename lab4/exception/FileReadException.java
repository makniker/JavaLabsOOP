package lab4.exception;

import java.io.IOException;

public class FileReadException extends IOException {
    public FileReadException() {
        super("Can`t read file");
    }

    public FileReadException(String message) {
        super(message);
    }
}
