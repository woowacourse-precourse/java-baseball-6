package baseball.model;

import baseball.model.baseball.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BallTest {
    Ball ball = new Ball(1);

    @Test
    @DisplayName("볼의 개수가 0인지 확인한다.")
    void check_no_count(){
        //given
        ball.updateBallCount(0);

        //when
        boolean isNoCountBall = ball.isNoCountBall();

        //then
        assertThat(isNoCountBall).isTrue();

    }




}
