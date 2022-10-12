package africa.semicolon.blogSystem.exceptions;

public class BlogServiceException extends RuntimeException {
    public BlogServiceException() {
    }

    public BlogServiceException(String message) {
        super(message);
    }

    public BlogServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogServiceException(Throwable cause) {
        super(cause);
    }
}
