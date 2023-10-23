package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNoTest {

    @Test
    void ballNo_under_one() {
        assertThatThrownBy(() -> new BallNo(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballNo_over_nine() {
        assertThatThrownBy(() -> new BallNo(10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
