package baseball.model;

import baseball.model.Ball;
import baseball.model.BallNumber;
import baseball.model.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    @DisplayName("숫자 값와 위치가 모두 같은 경우 - 스트라이크")
    void strike() {
        // given
        int comIndex = 0;
        BallNumber comNumber = BallNumber.of(1);
        int userIndex = 0;
        BallNumber userNumber = BallNumber.of(1);

        Ball com = Ball.of(comIndex, comNumber);
        Ball user = Ball.of(userIndex, userNumber);

        // when
        BallStatus status = com.compute(user);

        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("숫자 값은 같지만 위치가 다른 경우 - 볼")
    void ball() {
        // given
        int comIndex = 0;
        BallNumber comNumber = BallNumber.of(1);
        int userIndex = 1;
        BallNumber userNumber = BallNumber.of(1);

        Ball com = Ball.of(comIndex, comNumber);
        Ball user = Ball.of(userIndex, userNumber);

        // when
        BallStatus status = com.compute(user);

        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("숫자 값과 위치가 모두 다른 경우 - 낫싱")
    void nothing() {
        // given
        int comIndex = 0;
        BallNumber comNumber = BallNumber.of(1);
        int userIndex = 1;
        BallNumber userNumber = BallNumber.of(2);

        Ball com = Ball.of(comIndex, comNumber);
        Ball user = Ball.of(userIndex, userNumber);

        // when
        BallStatus status = com.compute(user);

        // then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}