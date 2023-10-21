package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    @DisplayName("0이하 숫자 입력시 예외 처리")
    void test() {
        assertThatThrownBy(() -> new Ball(0, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("10이상 숫자 입력시 예외 처리")
    void test2() {
        assertThatThrownBy(() -> new Ball(10, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼")
    void test3() {
        Ball ball = new Ball(1, 1);

        assertThat(ball.play(new Ball(1, 2))).isEqualTo("볼");
    }

    @Test
    @DisplayName("스트라이크")
    void test4() {
        Ball ball = new Ball(1, 1);

        assertThat(ball.play(new Ball(1, 1))).isEqualTo("스트라이크");
    }

    @Test
    @DisplayName("낫싱")
    void test5() {
        Ball ball = new Ball(1, 1);

        assertThat(ball.play(new Ball(2, 1))).isEqualTo("낫싱");
    }
}
