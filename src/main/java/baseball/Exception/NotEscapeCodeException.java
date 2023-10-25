package baseball.Exception;

public class NotEscapeCodeException extends IllegalArgumentException{
    public NotEscapeCodeException() {
        super("종료코드가 아닙니다.");
    }
}
