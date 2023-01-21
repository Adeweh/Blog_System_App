package africa.semicolon.blogSystem.exceptions;

public class PasswordIncorrectException extends ApplicationException {
    public PasswordIncorrectException() {
    }

    public PasswordIncorrectException(String message) {
        super(message);
    }

    public PasswordIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordIncorrectException(Throwable cause) {
        super(cause);
    }
}
