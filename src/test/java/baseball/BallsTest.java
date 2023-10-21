package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    void 원스트라이크() {
        Balls computer = new Balls("123");
        Balls player = new Balls("156");

        assertThat(computer.match(player)).isFalse();
    }

    @Test
    void 원볼() {
        Balls computer = new Balls("123");
        Balls player = new Balls("561");

        assertThat(computer.match(player)).isFalse();
    }

    @Test
    void 원스트라이크_원볼() {
        Balls computer = new Balls("163");
        Balls player = new Balls("561");

        assertThat(computer.match(player)).isFalse();
    }

    @Test
    void 쓰리스트라이크() {
        Balls computer = new Balls("561");
        Balls player = new Balls("561");

        assertThat(computer.match(player)).isTrue();
    }

    @Test
    void 유효성검사() {

        assertThatThrownBy(() -> new Balls("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Balls("1aa"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Balls("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
