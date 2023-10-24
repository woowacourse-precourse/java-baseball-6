package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
    static final int MIN = 0;
    static final int MAX = 3;

    @Test
    @DisplayName("입력된 숫자와 비교")
    void compareInputNumberWithAnswerNumber() {
        GameNumber inputNumber = new GameNumber("123");
        Game game = new Game();

        int strike = game.countStrike(inputNumber);
        int ball = game.countBall(inputNumber);

        assertThat(strike).isBetween(MIN, MAX);
        assertThat(ball).isBetween(MIN, MAX);
    }
}