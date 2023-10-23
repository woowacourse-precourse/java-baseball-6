package baseball.exception.player;

public class DuplicateNumberException extends IllegalArgumentException {
    private static final String DUPLICATE_NUMBER_MESSAGE = "중복된 숫자는 입력될 수 없습니다.";

    public DuplicateNumberException() {
        super(DUPLICATE_NUMBER_MESSAGE);
    }
}
