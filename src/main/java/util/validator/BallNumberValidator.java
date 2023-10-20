package util.validator;

public class BallNumberValidator {

    private static BallNumberValidator ballNumberValidator;
    private final static int MAX_BALL_NUMBER = 9;
    private final static int MIN_BALL_NUMBER = 1;

    private final static String ERR_MSG = "숫자 각각의 값은 1~9 이여야 합니다.";

    private BallNumberValidator() {
    }

    public static BallNumberValidator getInstance() {
        if (ballNumberValidator == null) {
            ballNumberValidator = new BallNumberValidator();
        }
        return ballNumberValidator;
    }

    public boolean validate(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(ERR_MSG);
        }
        return true;
    }

}
