package africa.semicolon.blogSystem.exceptions;

import org.springframework.core.NestedRuntimeException;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String message){
        super(message);

    }
}
