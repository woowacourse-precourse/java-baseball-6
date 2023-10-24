package baseball.Exception;

public class SizeNotMatchException extends IllegalArgumentException {
    public SizeNotMatchException() {
        super("올바르지 않은 크기의 질문이 들어왔습니다");
    }
}
