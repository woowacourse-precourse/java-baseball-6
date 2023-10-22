package baseball.exception;

public class NumbersInputException extends IllegalArgumentException{

    private static String ERROR_MESSAGE = "입력 시에는 숫자만을 입력해야 합니다.";

    public NumbersInputException() {
        super(ERROR_MESSAGE);
    }
}
