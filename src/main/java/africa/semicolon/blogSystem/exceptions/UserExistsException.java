package africa.semicolon.blogSystem.exceptions;

import org.springframework.core.NestedRuntimeException;

public class UserExistsException extends ApplicationException {
    public UserExistsException(String message){
        super(message);

    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
    }

    public UserExistsException() {
        super();
    }
}
