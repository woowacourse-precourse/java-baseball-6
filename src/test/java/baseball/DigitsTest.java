package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitsTest {

    @Test
    void 입력값의_ball_점수를_count_한다() {
        Digits computerDigits = Digits.generateFixedDigits("123");
        Digits userInput = Digits.generateFixedDigits("231");

        int ballCount = computerDigits.countBall(userInput);

        assertEquals(ballCount, 3);
    }

}