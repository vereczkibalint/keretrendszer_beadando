package exceptions;

public class MusicLengthTooShortException extends Throwable {
    public MusicLengthTooShortException(String message) {
        super(message);
    }
}
