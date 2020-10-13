package exceptions;

public class DateIsAfterTodayException extends Throwable {
    public DateIsAfterTodayException(String message) {
        super(message);
    }
}
