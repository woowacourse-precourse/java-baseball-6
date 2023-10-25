package baseball.domain.picker;

import baseball.domain.ball.Ball;

public interface BallPicker {
    Ball pickNumberInRange(int minValues, int maxValues);
}
