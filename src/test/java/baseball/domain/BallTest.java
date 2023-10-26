package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

    Ball randomBall;

    @BeforeEach
    void setUp() {
        randomBall = Ball.of(1, 1);
    }

    @Test
    void createBall() {
        Ball ball = Ball.of(1, 1);
        assertThat(ball).isEqualTo(randomBall);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10})
    void validateNumber(int number) {
        assertThatThrownBy(() -> Ball.of(number, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1~9 사이의 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, STRIKE",
            "1, 2, BALL",
            "2, 2, NOTHING",
    })
    void match(int number, int position, BallType expected) {
        Ball ball = Ball.of(number, position);
        assertThat(ball.match(randomBall)).isEqualTo(expected);
    }
}

