package baseball.exception;

public class InputNumberNotUnique extends IllegalArgumentException {
    private static final String INPUT_NUMBER_NOT_UNIQUE = "입력값 중 중복되는 숫자가 존재합니다.";

    public InputNumberNotUnique() {
        super(INPUT_NUMBER_NOT_UNIQUE);
    }
}
