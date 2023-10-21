package baseball.exception;

public class BallDuplicatedException extends IllegalArgumentException {

    private static final String errorFormat = "서로 다른 숫자를 입력해 주세요. (중복된 숫자 : %c)";

    public BallDuplicatedException(char duplicatedBall) {
        super(String.format(errorFormat, duplicatedBall));
    }
}
