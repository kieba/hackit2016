package exception;

public class AlreadyVotedException extends Exception {
    public AlreadyVotedException() {
    }

    public AlreadyVotedException(String message) {
        super(message);
    }

    public AlreadyVotedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyVotedException(Throwable cause) {
        super(cause);
    }

    public AlreadyVotedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
