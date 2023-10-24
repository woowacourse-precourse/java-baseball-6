package baseball.domain.game;

import baseball.domain.ball.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BallMapperTest {

    @Test
    @DisplayName("숫자로부터 공을 생성할 수 있다.")
    void mapFrom() {
        List<Ball> result = BallMapper.mapFrom(List.of(4, 5, 6));

        assertThat(result).containsExactly(
                new Ball(4, 1),
                new Ball(5, 2),
                new Ball(6, 3)
        );
    }
}