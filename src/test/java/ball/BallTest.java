package ball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private Ball ball;
    @BeforeEach
    void initBall(){
        ball = new Ball(0, 1);
    }

    @Test
    void ball_init_location_test() {
        assertThat(ball.getLocation()).isZero();
    }

    @Test
    void ball_digit_digit_test() {
        assertThat(ball.getDigit()).isOne();
    }

    @ParameterizedTest
    @CsvSource(value = {"0,2", "2,2", "0,9", "2,9"})
    @DisplayName("아무것도 안맞음(낫싱) 테스트")
    void none_matches_test(int location, int digit) {
        assertThat(ball.check(new Ball(location, digit))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void ball_test_same_place() {
        assertThat(ball.check(new Ball(0, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,1"})
    @DisplayName("볼 테스트")
    void ball_test(int location, int digit) {
        assertThat(ball.check(new Ball(location,digit))).isEqualTo(BallStatus.BALL);
    }
}