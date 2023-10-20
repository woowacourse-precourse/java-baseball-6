package baseball.model;

import static baseball.Constants.NUMBER_COUNTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessResultTest {

    private GuessResult guessResult;

    @BeforeEach()
    void init() {
        guessResult = new GuessResult();
    }

    @Test
    @DisplayName("스트라이크와 볼이 0이면 낫싱이라고 알려준다.")
    void when_strike_and_ball_is_zero_inform_is_nothing() {
        assertTrue(guessResult.isNothing());
    }

    @Test
    @DisplayName("모두 맞았을 경우 게임이 끝났다는 것을 알려준다.")
    void when_() {
        // given & when
        for (int i = 0; i < NUMBER_COUNTS; i++) {
            guessResult.addStrikeCount();
        }

        // then
        assertTrue(guessResult.isGameEnd());
    }
}
