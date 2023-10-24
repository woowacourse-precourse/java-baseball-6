package baseball.exception;

public class InputSizeNot3 extends IllegalArgumentException {

    private static final String INPUT_SIZE_NOT_3 = "3자리 숫자를 입력해야 합니다.";

    public InputSizeNot3() {
        super(INPUT_SIZE_NOT_3);
    }
}
