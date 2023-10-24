package baseball.Exception;

public class QueryMustPossibleIntegerException extends IllegalArgumentException{
    public QueryMustPossibleIntegerException() {
        super("질문에 올바르지 않은 값이 포함되어 있습니다.");
    }
}
