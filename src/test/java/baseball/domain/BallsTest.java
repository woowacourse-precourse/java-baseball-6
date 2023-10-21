package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @DisplayName("볼의 개수가 3개가 아니라면 예외 발생")
    @Test
    void createBalls() {
        // given
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(1, 1));

        // when, then
        assertThatThrownBy(() -> new Balls(ballList))
                .isInstanceOf(IllegalArgumentException.class);

    }
}