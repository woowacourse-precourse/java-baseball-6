package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    void 원스트라이크() {
        Balls computer = new Balls(new Ball(1), new Ball(2), new Ball(3));
        Balls player = new Balls(new Ball(1), new Ball(5), new Ball(6));

        GameResult result = computer.getGameResult(player);
        assertThat(result.toString()).isEqualTo("1스트라이크");
    }

    @Test
    void 원볼() {
        Balls computer = new Balls(new Ball(1), new Ball(2), new Ball(3));
        Balls player = new Balls(new Ball(5), new Ball(6), new Ball(1));

        GameResult result = computer.getGameResult(player);
        assertThat(result.toString()).isEqualTo("1볼");
    }

    @Test
    void 원스트라이크_원볼() {
        Balls computer = new Balls(new Ball(1), new Ball(6), new Ball(3));
        Balls player = new Balls(new Ball(5), new Ball(6), new Ball(1));

        GameResult result = computer.getGameResult(player);
        assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 쓰리스트라이크() {
        Balls computer = new Balls(new Ball(5), new Ball(6), new Ball(1));
        Balls player = new Balls(new Ball(5), new Ball(6), new Ball(1));

        GameResult result = computer.getGameResult(player);
        assertThat(result.toString()).isEqualTo("3스트라이크");
        assertThat(result.isThreeStrike()).isTrue();
    }

    @Test
    void 유효성검사() {

        assertThatThrownBy(() -> new Balls(new Ball(5), new Ball(5), new Ball(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
