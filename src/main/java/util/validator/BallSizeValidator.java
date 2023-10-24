package util.validator;

import domain.Ball;
import java.util.List;

public class BallSizeValidator {

    private static BallSizeValidator ballSizeValidator;

    private static final int NUMBERS_SIZE = 3;

    private static final String ERR_MSG = "3자리 수만 입력 가능합니다.";

    private BallSizeValidator() {

    }

    public static BallSizeValidator getInstance() {
        if (ballSizeValidator == null) {
            ballSizeValidator = new BallSizeValidator();
        }
        return ballSizeValidator;
    }

    public boolean validate(List<Ball> balls) {
        if (balls.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERR_MSG);
        }
        return true;
    }
}
