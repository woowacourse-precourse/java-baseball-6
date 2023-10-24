package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(List.of(4, 3, 7));
    }

    @Test
    void 스트라이크() {
        assertThat(balls.compare(4, 0)).isEqualTo(0);
        assertThat(balls.compare(3, 1)).isEqualTo(0);
        assertThat(balls.compare(7, 2)).isEqualTo(0);
    }

    @Test
    void 볼() {
        assertThat(balls.compare(4, 1)).isEqualTo(1);
        assertThat(balls.compare(4, 2)).isEqualTo(1);
        assertThat(balls.compare(3, 0)).isEqualTo(1);
        assertThat(balls.compare(3, 2)).isEqualTo(1);
        assertThat(balls.compare(7, 0)).isEqualTo(1);
        assertThat(balls.compare(7, 1)).isEqualTo(1);
    }

    @Test
    void 낫싱() {
        assertThat(balls.compare(2, 0)).isEqualTo(2);
        assertThat(balls.compare(6, 1)).isEqualTo(2);
        assertThat(balls.compare(1, 2)).isEqualTo(2);
    }
}
