package exception;

import javax.servlet.ServletException;

public class InvalidRequestException extends ServletException {

    public InvalidRequestException() {
    }


    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestException(Throwable cause) {
        super(cause);
    }

}
