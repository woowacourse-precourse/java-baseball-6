package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    Balls comBalls;

    @BeforeEach
    void before() {
        comBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("낫싱 테스트")
    void test() {
        assertThat(comBalls.play(new Ball(4, 1))).isEqualTo(BallResultEnum.NOTHING);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void test2() {

        assertThat(comBalls.play(new Ball(1, 1))).isEqualTo(BallResultEnum.STRIKE);
    }

    @Test
    @DisplayName("볼 테스트")
    void test3() {

        assertThat(comBalls.play(new Ball(1, 2))).isEqualTo(BallResultEnum.BALL);
    }

    @Test
    @DisplayName("2볼 테스트")
    void test4() {
        PlayResult playResult = comBalls.play(new Balls(Arrays.asList(2, 1, 4)));

        assertThat(playResult.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("2스트라이크 테스트")
    void test5() {
        PlayResult playResult = comBalls.play(new Balls(Arrays.asList(1, 2, 4)));

        assertThat(playResult.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("1스트라이크 1볼 테스트")
    void test6() {
        PlayResult playResult = comBalls.play(new Balls(Arrays.asList(1, 4, 2)));

        assertThat(playResult.getStrike()).isEqualTo(1);
        assertThat(playResult.getBall()).isEqualTo(1);
    }
}
