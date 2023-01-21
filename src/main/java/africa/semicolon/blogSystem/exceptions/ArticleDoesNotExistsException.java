package africa.semicolon.blogSystem.exceptions;

public class ArticleDoesNotExistsException extends ApplicationException {
    public ArticleDoesNotExistsException() {
    }

    public ArticleDoesNotExistsException(String message) {
        super(message);
    }

    public ArticleDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleDoesNotExistsException(Throwable cause) {
        super(cause);
    }
}
