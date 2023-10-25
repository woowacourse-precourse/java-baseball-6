package baseball.Exception;

public class NumberDuplicateException extends IllegalArgumentException{
    public NumberDuplicateException() {
        super("질문에 중복된 숫자가 존재합니다.");
    }
}
