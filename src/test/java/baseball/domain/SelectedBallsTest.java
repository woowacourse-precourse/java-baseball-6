package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SelectedBallsTest {

    @DisplayName("3자리 숫자의 ball이 생성되어야 한다.")
    @Test
    void Int3BallTest() {
        // given
        SelectedBalls newSelectedBalls = SelectedBalls.getNewSelectedBalls();

        // when
        String balls = newSelectedBalls.getStringOfBalls();

        // then
        assertThat(Integer.parseInt(balls)).isExactlyInstanceOf(Integer.class);
        assertThat(balls.length()).isEqualTo(3);
    }

    @DisplayName("겹치지 않는 숫자의 ball이 생성되어야 한다.")
    @Test
    void duplicateBallTest() {
        // given
        SelectedBalls newSelectedBalls = SelectedBalls.getNewSelectedBalls();

        // when
        String balls = newSelectedBalls.getStringOfBalls();

        // then
        assertThat(balls.chars().distinct().count()).isEqualTo(3);
    }

    @DisplayName("1~9범위의 숫자 ball이 생성되어야 한다.")
    @Test
    void getStringOfBallsTest() {
        // given
        SelectedBalls newSelectedBalls = SelectedBalls.getNewSelectedBalls();

        // when
        String balls = newSelectedBalls.getStringOfBalls();
        boolean hasBallOutOfRange = Arrays.stream(balls.split(""))
                .mapToInt(Integer::parseInt)
                .noneMatch(ball -> ball >= 1 && ball <= 9);

        // then
        assertThat(hasBallOutOfRange).isFalse();
    }

    @DisplayName("매번 다른 번호의 ball이 생성되어야 한다.")
    @RepeatedTest(5)
    void getNewSelectedBallsTest() {
        // given
        SelectedBalls newSelectedBalls1 = SelectedBalls.getNewSelectedBalls();
        SelectedBalls newSelectedBalls2 = SelectedBalls.getNewSelectedBalls();

        // when
        String balls1 = newSelectedBalls1.getStringOfBalls();
        String balls2 = newSelectedBalls2.getStringOfBalls();

        // then
        assertThat(balls1).isNotEqualTo(balls2);
    }
}