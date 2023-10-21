package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Ball;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void ballValidateRangeTest() {
        Ball ball = new Ball(1, 0);
        assertThatThrownBy(() -> ball.validateRange(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력은 0을 포함할 수 없슴니다.");

    }
}
