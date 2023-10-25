package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();

    @Test
    void strikeTest() {
        boolean strike = baseballGame.isStrike(1, 0, Arrays.asList(1, 2, 3));
        assertThat(strike).isTrue();
        strike = baseballGame.isStrike(2, 0, Arrays.asList(1, 2, 3));
        assertThat(strike).isFalse();
    }

    @Test
    void ballTest() {
        boolean ball = baseballGame.isBall(1, 1, Arrays.asList(1, 2, 3));
        assertThat(ball).isTrue();
        ball = baseballGame.isBall(1, 0, Arrays.asList(1, 2, 3));
        assertThat(ball).isFalse();
    }

    @Test
    void nothingTest() {
        boolean nothing = baseballGame.isNothing(4, Arrays.asList(1, 2, 3));
        assertThat(nothing).isTrue();
        nothing = baseballGame.isNothing(2, Arrays.asList(1, 2, 3));
        assertThat(nothing).isFalse();
    }

    @Test
    void calcResultTest() {
        List<Integer> results = baseballGame.calcResult(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(results).isEqualTo(Arrays.asList(3, 0, 0));

        results = baseballGame.calcResult(Arrays.asList(3, 2, 1), Arrays.asList(1, 2, 3));
        assertThat(results).isEqualTo(Arrays.asList(1, 2, 0));

        results = baseballGame.calcResult(Arrays.asList(4, 5, 6), Arrays.asList(1, 2, 3));
        assertThat(results).isEqualTo(Arrays.asList(0, 0, 3));
    }
}