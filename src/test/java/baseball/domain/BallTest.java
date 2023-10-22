package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallTest {


    @DisplayName("같은 숫자 같은 포지션 true 테스트")
    @ParameterizedTest
    @MethodSource("createSameNumberSamePositionData")
    void Ball_같은위치_같은포지션_true(Ball ball, Ball otherBall) {
        Assertions.assertThat(ball.isSameNumberAndSamePosition(otherBall)).isTrue();
    }

    public static Stream<Arguments> createSameNumberSamePositionData() {
        return Stream.of(
                Arguments.of(new Ball(new Number(1),0),new Ball(new Number(1),0)),
                Arguments.of(new Ball(new Number(5),1),new Ball(new Number(5),1)),
                Arguments.of(new Ball(new Number(9),2),new Ball(new Number(9),2))
        );
    }

    @DisplayName("같은 숫자 같은 포지션 false 테스트")
    @ParameterizedTest
    @MethodSource("createNotSameNumberOrNotSamePositionData")
    void Ball_같은위치_같은포지션_false(Ball ball, Ball otherBall) {
        Assertions.assertThat(ball.isSameNumberAndSamePosition(otherBall)).isFalse();
    }

    public static Stream<Arguments> createNotSameNumberOrNotSamePositionData() {
        return Stream.of(
                Arguments.of(new Ball(new Number(1),0),new Ball(new Number(2),0)),
                Arguments.of(new Ball(new Number(4),1),new Ball(new Number(5),1)),
                Arguments.of(new Ball(new Number(5),2),new Ball(new Number(9),2))
        );
    }


    @DisplayName("같은 숫자 다른 포지션 true 테스트")
    @ParameterizedTest
    @MethodSource("createSameNumberOrOtherPositionData")
    void Ball_같은위치_다른포지션_true(Ball ball, Ball otherBall) {
        Assertions.assertThat(ball.isSameNumberAndOtherPosition(otherBall)).isTrue();
    }

    public static Stream<Arguments> createSameNumberOrOtherPositionData() {
        return Stream.of(
                Arguments.of(new Ball(new Number(1),0),new Ball(new Number(1),1)),
                Arguments.of(new Ball(new Number(4),1),new Ball(new Number(4),0)),
                Arguments.of(new Ball(new Number(5),2),new Ball(new Number(5),1))
        );
    }

    @DisplayName("같은 숫자 다른 포지션 false 테스트")
    @ParameterizedTest
    @MethodSource("createNotSameNumberOrNotSamePositionData")
    void Ball_같은위치_다른포지션_false(Ball ball, Ball otherBall) {
        Assertions.assertThat(ball.isSameNumberAndOtherPosition(otherBall)).isFalse();
    }


}