package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.domain.Ball;
import baseball.domain.TryResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void from은_올바르지_않은_범위값을_받는_경우_Exception을_반환한다(int number) {
        assertThatThrownBy(() -> Ball.from(1, number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력은 0을 포함할 수 없슴니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void from은_올바른_범위값을_받는_경우_Exception을_반환하지_않고_올바른_객체를_생성한다(int number) {
        assertDoesNotThrow(() -> Ball.from(1, number));
    }


    @ParameterizedTest
    @CsvSource(value = {"1, 1, STRIKE", "2, 1, BALL", "1, 3, NOTHING"})
    void getTryResult는_Ball과_정답Ball의_자리와_숫자값에_따른_비교결과를_반환한다(int position, int number, TryResult tryResult) {
        Ball ball = Ball.from(1, 1);
        Ball answerBall = Ball.from(position, number);
        assertThat(ball.getTryResult(answerBall)).isEqualTo(tryResult);

    }

    @ParameterizedTest
    @CsvSource(value = {"2, 1, true", "1, 3, false"})
    void isSameNumber는_공과공이_같은숫자를_포함하고있는지를_반환한다(int position, int number, boolean isSameNumber) {
        Ball ball = Ball.from(1, 1);
        Ball answerBall = Ball.from(position, number);
        assertThat(ball.isSameNumber(answerBall)).isEqualTo(isSameNumber);
    }
}
