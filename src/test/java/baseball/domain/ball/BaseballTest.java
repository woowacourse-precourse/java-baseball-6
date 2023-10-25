package baseball.domain.ball;


import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballTest {


    @DisplayName("같은 숫자 같은 포지션 true 테스트")
    @ParameterizedTest
    @MethodSource("createSameNumberSamePositionData")
    void Ball_같은위치_같은포지션_true(Baseball baseball, Baseball otherBaseball) {
        Assertions.assertThat(baseball.isMatch(otherBaseball)).isTrue();
    }

    public static Stream<Arguments> createSameNumberSamePositionData() {
        return Stream.of(
                Arguments.of(new Baseball(new Number(1), 0), new Baseball(new Number(1), 0)),
                Arguments.of(new Baseball(new Number(5), 1), new Baseball(new Number(5), 1)),
                Arguments.of(new Baseball(new Number(9), 2), new Baseball(new Number(9), 2))
        );
    }

    @DisplayName("같은 숫자 같은 포지션 false 테스트")
    @ParameterizedTest
    @MethodSource("createNotSameNumberOrNotSamePositionData")
    void Ball_같은위치_같은포지션_false(Baseball baseball, Baseball otherBaseball) {
        Assertions.assertThat(baseball.isMatch(otherBaseball)).isFalse();
    }

    public static Stream<Arguments> createNotSameNumberOrNotSamePositionData() {
        return Stream.of(
                Arguments.of(new Baseball(new Number(1), 0), new Baseball(new Number(2), 0)),
                Arguments.of(new Baseball(new Number(4), 1), new Baseball(new Number(5), 1)),
                Arguments.of(new Baseball(new Number(5), 2), new Baseball(new Number(9), 2))
        );
    }


    @DisplayName("같은 숫자 다른 포지션 true 테스트")
    @ParameterizedTest
    @MethodSource("createSameNumberOrOtherPositionData")
    void Ball_같은위치_다른포지션_true(Baseball baseball, Baseball otherBaseball) {
        Assertions.assertThat(baseball.isPartialMatch(otherBaseball)).isTrue();
    }

    public static Stream<Arguments> createSameNumberOrOtherPositionData() {
        return Stream.of(
                Arguments.of(new Baseball(new Number(1), 0), new Baseball(new Number(1), 1)),
                Arguments.of(new Baseball(new Number(4), 1), new Baseball(new Number(4), 0)),
                Arguments.of(new Baseball(new Number(5), 2), new Baseball(new Number(5), 1))
        );
    }

    @DisplayName("같은 숫자 다른 포지션 false 테스트")
    @ParameterizedTest
    @MethodSource("createNotSameNumberOrNotSamePositionData")
    void Ball_같은위치_다른포지션_false(Baseball baseball, Baseball otherBaseball) {
        Assertions.assertThat(baseball.isPartialMatch(otherBaseball)).isFalse();
    }


}