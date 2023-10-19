package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void ballValidateRangeTest() {
        Ball ball = Ball.from();
        assertThatThrownBy(() -> ball.validateForm("$"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("올바른 숫자를 입력해주세요.");
    }
}
