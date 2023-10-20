package util.validator;

public class BallIndexValidator {

    private static BallIndexValidator ballIndexValidator;
    private static final int MIN_BALL_INDEX = 1;
    private static final int MAX_BALL_INDEX = 3;
    private static final String ERR_MSG = "공의 인덱스는 1 - 3 이여야 합니다.";

    private BallIndexValidator() {

    }

    public static BallIndexValidator getInstance() {
        if (ballIndexValidator == null) {
            ballIndexValidator = new BallIndexValidator();
        }
        return ballIndexValidator;
    }

    public boolean validate(int index) {
        if (index < MIN_BALL_INDEX || index > MAX_BALL_INDEX) {
            throw new IllegalArgumentException(ERR_MSG);
        }
        return true;
    }
}
