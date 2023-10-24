package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballResultStateTest {
    @Test
    void testToString() {
        int[] balls = {2, 0, 1, 0};
        int[] strikes = {1, 2, 0, 0};
        String[] answers = {"2볼 1스트라이크", "2스트라이크", "1볼", "낫싱"};

        for (int i=0; i<balls.length; i++) {
            int ball = balls[i];
            int strike = strikes[i];
            String answer = answers[i];
            BaseballResultState state = new BaseballResultState(ball, strike);
            assertEquals(state.toString(), answer);
        }
    }
}