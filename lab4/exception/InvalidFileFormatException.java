package lab4.exception;

public class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException() {
        super("Can't read dictionary");
    }

    public InvalidFileFormatException(String message) {
        super(message);
    }
}
