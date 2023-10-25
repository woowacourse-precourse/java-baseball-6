package baseball;

import static baseball.domain.TryResult.BALL;
import static baseball.domain.TryResult.NOTHING;
import static baseball.domain.TryResult.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.util.InputConvertor;
import baseball.util.InputValidator;
import baseball.domain.TryResult;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallsTest {

    public static List<Ball> DEFAULT_BALLS_123 = Arrays.asList(Ball.from(1, 1), Ball.from(2, 2),
        Ball.from(3, 3));

    @Test
    void from는__ball리스트를_받아에_balls_객체를_응답한다() {
        Ball ball1 = Ball.from(1, 1);
        Ball ball2 = Ball.from(2, 2);
        Ball ball3 = Ball.from(3, 3);
        Balls balls = Balls.from(List.of(ball1, ball2, ball3));
        assertThat(balls.getBalls()).isEqualTo(List.of(ball1, ball2, ball3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    void 맞지않는_자리수를_입력한_경우_예외를_반환한다(String rawBalls) {
        List<Integer> rawBallList = InputConvertor.convertBalls(rawBalls);
        assertThatThrownBy(() -> InputValidator.validateBallsCount(rawBallList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("3자리의 숫자를 입력해주세요.");
    }

    @Test
    void 중복된_숫자를_입력한_경우_예외를_반환한다() {
        assertThatThrownBy(
            () -> Balls.from(List.of(Ball.from(1, 1), Ball.from(1, 1), Ball.from(1, 2))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복되지 않는 3자리의 숫자를 입력해주세요.");

    }

    public static Stream<Arguments> tryResult() {
        return Stream.of(
            Arguments.of(1, 2, 3, STRIKE, STRIKE, STRIKE),
            Arguments.of(2, 3, 1, BALL, BALL, BALL),
            Arguments.of(1, 3, 5, STRIKE, BALL, NOTHING),
            Arguments.of(4, 5, 6, NOTHING, NOTHING, NOTHING)
        );
    }

    @ParameterizedTest
    @MethodSource("tryResult")
    void getTryResultList는_공번호와_자리수가_일치하는것에_따라_비교결과를_담은_리스트를_반환한다(int num1, int num2,
        int num3, TryResult result1, TryResult result2, TryResult result3) {
        Balls answerBall = Balls.from(DEFAULT_BALLS_123);
        Balls balls = Balls.from(Arrays.asList(Ball.from(1, num1), Ball.from(2, num2), Ball.from(3, num3)));
        assertThat(balls.getTryResultList(answerBall).getTryResults()).containsExactly(
            result1, result2, result3);
    }
}
