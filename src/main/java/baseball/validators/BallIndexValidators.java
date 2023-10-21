package baseball.validators;

import baseball.balls.Balls;

public final class BallIndexValidators {

    public static void validateIndexRange(int value) {
        boolean isUnderIndex = value < 0;
        boolean isOverIndex = value >= Balls.BALL_COUNT;
        if (isUnderIndex || isOverIndex) {
            throw new IllegalArgumentException("공의 위치값이 유효하지 않습니다");
        }
    }

}
