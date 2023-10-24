package baseball;

public class InvalidAnswerInputException extends IllegalArgumentException {

    private static final String MESSAGE = "유효하지 않은 게임 숫자 입력입니다.";

    public InvalidAnswerInputException() {
        super(MESSAGE);
    }
}
