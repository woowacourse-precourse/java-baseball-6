package baseball.domain.role;

import baseball.domain.ball.Ball;

public interface BallPicker {
    Ball pickNumberInRange(int minValues, int maxValues) throws IllegalAccessException;
}
