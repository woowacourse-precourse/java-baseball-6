package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    @DisplayName("낫싱 테스트")
    void test() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(new Ball(4, 1))).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void test2() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(new Ball(1, 1))).isEqualTo("스트라이크");
    }

    @Test
    @DisplayName("볼 테스트")
    void test3() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(balls.play(new Ball(1, 2))).isEqualTo("볼");
    }
}
