package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static baseball.exception.ExceptionMessage.BaseballException.EACH_BALL_MUST_BE_UNIQUE;
import static baseball.exception.ExceptionMessage.BaseballException.INVALID_BALL_COUNT;
import static baseball.exception.ExceptionMessage.BaseballException.SPECIFIC_BALL_IS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BaseballTest {
    @ParameterizedTest
    @MethodSource("invalidCount")
    @DisplayName("총 개수가 3개가 아니면 Baseball은 생성할 수 없다")
    void throwExceptionByInvalidCount(final List<Integer> balls) {
        assertThatThrownBy(() -> Baseball.of(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BALL_COUNT.message);
    }

    private static Stream<Arguments> invalidCount() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(List.of(1)),
                Arguments.arguments(List.of(1, 2)),
                Arguments.arguments(List.of(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidRange")
    @DisplayName("1..9 범위가 아닌 숫자가 존재할 경우 Baseball은 생성할 수 없다")
    void throwExceptionByInvalidRange(final List<Integer> balls) {
        assertThatThrownBy(() -> Baseball.of(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SPECIFIC_BALL_IS_NOT_IN_RANGE.message);
    }

    private static Stream<Arguments> invalidRange() {
        return Stream.of(
                Arguments.arguments(List.of(-1, 1, 9)),
                Arguments.arguments(List.of(0, 1, 9)),
                Arguments.arguments(List.of(1, 9, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicate")
    @DisplayName("중복된 숫자가 존재할 경우 Baseball은 생성할 수 없다")
    void throwExceptionByDuplicateBall(final List<Integer> balls) {
        assertThatThrownBy(() -> Baseball.of(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EACH_BALL_MUST_BE_UNIQUE.message);
    }

    private static Stream<Arguments> duplicate() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 2)),
                Arguments.arguments(List.of(2, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("success")
    @DisplayName("Baseball을 생성한다")
    void construct(final List<Integer> balls) {
        assertDoesNotThrow(() -> Baseball.of(balls));
    }

    private static Stream<Arguments> success() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3)),
                Arguments.arguments(List.of(2, 5, 9))
        );
    }
}
