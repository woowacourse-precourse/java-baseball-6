package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    private final UserInputNumbers userInputNumbers = new UserInputNumbers("135");

    private final List<Number> randomNumberList = Arrays.asList(
            new Number(1),
            new Number(2),
            new Number(3));
    private final RandomNumbers randomNumbers = new RandomNumbers(randomNumberList);

    @Test
    @DisplayName("랜덤숫자 123, 유저숫자 135 일 때 볼은 1이다.")
    void countBalls() {
        int ballCount = new Balls(randomNumbers, userInputNumbers).getBallCount();
        assertEquals(1, ballCount);
    }
}