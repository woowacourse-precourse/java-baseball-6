package baseball.exception.player;

public class InputSizeException extends IllegalArgumentException {
    private static final String INPUT_SIZE_MESSAGE = "4개 이상의 공이 입력될 수 없습니다.";

    public InputSizeException() {
        super(INPUT_SIZE_MESSAGE);
    }
}
