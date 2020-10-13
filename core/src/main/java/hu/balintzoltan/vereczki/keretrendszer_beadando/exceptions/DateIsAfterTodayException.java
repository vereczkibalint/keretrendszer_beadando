package hu.balintzoltan.vereczki.keretrendszer_beadando.exceptions;

public class DateIsAfterTodayException extends Throwable {
    public DateIsAfterTodayException(String message) {
        super(message);
    }
}
