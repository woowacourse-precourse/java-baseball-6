package baseball.exception.rutime;

public class NotInitializeBallException extends RuntimeException {

    public NotInitializeBallException() {
        super("공이 초기화되지 않았습니다.");
    }
}
