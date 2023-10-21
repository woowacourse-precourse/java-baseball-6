package baseball.exception;

public class InputExceedSize4 extends IllegalArgumentException {
    private static final String INPUT_EXCEED_SIZE_4_MSG = "3자리 숫자를 입력해야 합니다.";

    public InputExceedSize4() {
        super(INPUT_EXCEED_SIZE_4_MSG);
    }
}
