package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Ball computer;

    @BeforeEach
    void setUp() {
        computer = new Ball(0, 1);
    }

    @Test
    @DisplayName("똑같은 위치와 숫자일때 STRIKE 검증")
    void strike() {
        BallStatus status = computer.play(new Ball(0, 1));
        BallStatus status2 = computer.play(new Ball(0, 3));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
        assertThat(status2).isNotEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("다른 위치와 같은 숫자일때 BALL 검증")
    void ball() {
        BallStatus status = computer.play(new Ball(1, 1));
        BallStatus status2 = computer.play(new Ball(0, 1));
        assertThat(status).isEqualTo(BallStatus.BALL);
        assertThat(status2).isNotEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("다른 위치와 다른 숫자일때 NOTHING 검증")
    void nothing() {
        BallStatus status = computer.play(new Ball(0, 5));
        BallStatus status2 = computer.play(new Ball(0, 1));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
        assertThat(status2).isNotEqualTo(BallStatus.NOTHING);
    }
}
