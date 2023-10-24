package baseball.exception;

public class InputNotNumber extends IllegalArgumentException {
    private static final String INPUT_NOT_NUMBER = "문자가 아닌 숫자를 입력해야 합니다.";

    public InputNotNumber() {
        super(INPUT_NOT_NUMBER);
    }
}
