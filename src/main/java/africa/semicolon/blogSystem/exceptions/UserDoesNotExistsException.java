package africa.semicolon.blogSystem.exceptions;

public class UserDoesNotExistsException extends ApplicationException {
    public UserDoesNotExistsException(String message){
        super(message);
    }

    public UserDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDoesNotExistsException(Throwable cause) {
        super(cause);
    }

    public UserDoesNotExistsException() {
        super();
    }
}
