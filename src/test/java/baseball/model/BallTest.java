package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static baseball.exception.ErrorMessage.INVALID_BALL_NUMBER;
import static baseball.model.BallStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @DisplayName("Ball 생성 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void createBall(int num) throws Exception {
        //when
        Ball ball = new Ball(num);

        //then
        assertThat(ball.getNum()).isEqualTo(num);
    }

    @DisplayName("Ball 생성 예외 : 1-9 범위의 숫자가 아닐때 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    public void createBall_exception_invalid_num(int illegalNumber) throws Exception {
        //when, then
        assertThatThrownBy(() -> new Ball(illegalNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BALL_NUMBER.toString());
    }


    @DisplayName("Ball과 Ball을 비교해서 같으면 True")
    @ParameterizedTest
    @CsvSource({"1,1", "3,3", "5,5"})
    public void compareBallWithBall_true(int num1, int num2) throws Exception {
        //given
        Ball ball1 = new Ball(num1);
        Ball ball2 = new Ball(num2);

        //when, then
        assertThat(ball1.equals(ball2)).isTrue();
    }

    @DisplayName("Ball과 Ball을 비교해서 틀리면 False")
    @ParameterizedTest
    @CsvSource({"1,2", "2,3", "1,5"})
    public void compareBallWithBall_false(int num1, int num2) throws Exception {
        //given
        Ball ball1 = new Ball(num1);
        Ball ball2 = new Ball(num2);

        //when, then
        assertThat(ball1.equals(ball2)).isFalse();
    }

    @DisplayName("특정 인덱스의 Ball과 Balls을 비교 : 1STRIKE 2NOTHING")
    @Test
    public void compareBallWithBalls_1STRIKE() throws Exception {
        //given
        Ball ball = new Ball(1);
        int index = 0;
        Balls balls = new Balls(List.of(1, 2, 3));

        //when
        List<BallStatus> ballStatuses = ball.checkBalls(index, balls);

        //then
        assertThat(ballStatuses).containsExactly(STRIKE, NOTHING, NOTHING);
    }

    @DisplayName("특정 인덱스의 Ball과 Balls을 비교 : 1BALL 2NOTHING")
    @Test
    public void compareBallWithBalls_1BALL() throws Exception {
        //given
        Ball ball = new Ball(1);
        int index = 1;
        Balls balls = new Balls(List.of(1, 2, 3));

        //when
        List<BallStatus> ballStatuses = ball.checkBalls(index, balls);

        //then
        assertThat(ballStatuses).containsExactly(BALL, NOTHING, NOTHING);
    }
}
