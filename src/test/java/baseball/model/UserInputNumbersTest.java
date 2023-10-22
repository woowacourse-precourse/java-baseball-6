package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputNumbersTest {

    private final UserInputNumbers userInputNumbers = new UserInputNumbers("135");

    private final List<Number> randomNumberList = Arrays.asList(
            new Number(1),
            new Number(2),
            new Number(3));
    private final RandomNumbers randomNumbers = new RandomNumbers(randomNumberList);

    @Test
    @DisplayName("랜덤숫자 123, 유저숫자 135 일 때 스트라이크는 1이다.")
    void countStrikes() {
        int strikeCount = userInputNumbers.countStrikes(randomNumbers);
        assertEquals(1, strikeCount);
    }

    @Test
    @DisplayName("랜덤숫자 123, 유저숫자 135 일 때 볼은 1이다.")
    void countBalls() {
        int ballCount = userInputNumbers.countBalls(randomNumbers);
        assertEquals(1, ballCount);
    }
}