package baseball.validators;

import baseball.balls.BallValue;

public final class BallValueValidators {

    public static void validateValueRange(int value) {
        boolean isUnderValue = value < BallValue.MIN_VALUE;
        boolean isOverValue = value > BallValue.MAX_VALUE;
        if (isUnderValue || isOverValue) {
            throw new IllegalArgumentException("공의 값이 유효하지 않습니다");
        }
    }

}
