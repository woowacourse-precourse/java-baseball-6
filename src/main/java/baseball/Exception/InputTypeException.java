package baseball.Exception;

public class InputTypeException extends IllegalArgumentException{
    public InputTypeException() {
        super("정수를 입력해주세요.");
    }
}
