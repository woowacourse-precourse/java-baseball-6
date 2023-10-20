package util.validator;

import domain.Ball;
import domain.BallNumber;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BallDuplicateValidator {

    private static BallDuplicateValidator ballDuplicateValidator;

    private final int NUMBER_SIZE = 3;

    private final String ERR_MSG = "중복된 숫자가 존재합니다.";

    private BallDuplicateValidator() {

    }

    public static BallDuplicateValidator getInstance() {
        if (ballDuplicateValidator == null) {
            ballDuplicateValidator = new BallDuplicateValidator();
        }
        return ballDuplicateValidator;
    }

    public boolean validate(List<Ball> ballList) {
        Set<Integer> ballsSet = ballList.stream()
                .map(Ball::getBallNumber)
                .map(BallNumber::getBallNumber)
                .collect(Collectors.toSet());
        if (ballsSet.size() != 3) {
            throw new IllegalArgumentException(ERR_MSG);
        }
        return true;
    }
}
