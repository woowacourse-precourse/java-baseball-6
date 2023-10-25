package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.util.InputConvertor;
import baseball.util.InputValidator;
import baseball.domain.TryResult;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsTest {

    public static Stream<Arguments> BallsFrom() {
        return Stream.of(
            Arguments.of(),
            Arguments.of()
        );
    }

    @ParameterizedTest
    @MethodSource(value = "BallsFrom")
    void from는__ball리스트를_받아에_balls_객체를_응답한다() {
        Ball ball1 = mock(Ball.class);
        Ball ball2 = mock(Ball.class);
        Ball ball3 = mock(Ball.class);
        Balls balls = Balls.from(List.of(ball1, ball2, ball3));
        assertThat(balls.getBalls()).isEqualTo(List.of(ball1, ball2, ball3));
    }

    public static Stream<Arguments> newBall() {
        return Stream.of(
            Arguments.of(Ball.from(1, 1), true)
            , Arguments.of(Ball.from(1, 2), false)
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    void _2자리_4자리_입력한_경우(String rawBalls) {
        List<Integer> rawBallList = InputConvertor.convertBalls(rawBalls);
        assertThatThrownBy(() -> InputValidator.validateBallsCount(rawBallList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("3자리의 숫자를 입력해주세요.");
    }


    @Test
// MethodSource
    void ballHasDuplicates() {
        assertThatThrownBy(
            () -> Balls.from(List.of(Ball.from(1, 1), Ball.from(1, 1), Ball.from(1, 2))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되지 않는 3자리의 숫자를 입력해주세요.");

    }

    @ParameterizedTest
    @MethodSource("newBall")
    void 정답_1_입력1일때_true_정답2_입력1일때_false를_반환한다(Ball newBall, boolean isSameBall) {
        Ball otherBall = Ball.from(1, 1);
        assertThat(newBall.equals(otherBall)).isEqualTo(isSameBall);
    }

    public static Stream<Arguments> tryResult() {
        return Stream.of(
            Arguments.of(1, 2, 3, TryResult.STRIKE, TryResult.STRIKE, TryResult.STRIKE),
            Arguments.of(2, 3, 1, TryResult.BALL, TryResult.BALL, TryResult.BALL),
            Arguments.of(1, 3, 5, TryResult.STRIKE, TryResult.BALL, TryResult.NOTHING),
            Arguments.of(4, 5, 6, TryResult.NOTHING, TryResult.NOTHING, TryResult.NOTHING)
        );
    }

    @ParameterizedTest
    @MethodSource("tryResult")
    void 정답123_입력_123일때_strike3_231일때_ball3_135일때_strike_1_ball_1을_반환한다(int num1, int num2,
        int num3, TryResult result1, TryResult result2, TryResult result3) {
        Balls balls = new Balls(Ball.from(1, num1), Ball.from(2, num2), Ball.from(3, num3));
        Balls answerBall = new Balls(Ball.from(1, 1), Ball.from(2, 2), Ball.from(3, 3));
        assertThat(balls.getTryResultList(answerBall).getTryResults()).containsExactly(
            result1, result2, result3);
    }
}
