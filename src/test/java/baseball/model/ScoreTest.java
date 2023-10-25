package baseball.model;

import baseball.constant.Hint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    @DisplayName("3스트라이크 아웃 테스트")
    @ParameterizedTest(name = "{index} {displayName}")
    @MethodSource("threeStrikeParametersProvider")
    void isStrikeOut(Score score, Boolean expected) {
        assertThat(score.isStrikeOut()).isEqualTo(expected);
    }

    @DisplayName("toString 메서드 테스트")
    @ParameterizedTest(name = "{index} {displayName}")
    @MethodSource("toStringParametersProvider")
    void checkToString(Score score, String expected) {
        assertThat(score.toString()).contains(expected);
    }

    static Stream<Arguments> threeStrikeParametersProvider() {
        return Stream.of(
                Arguments.arguments(new Score(Map.of(Hint.STRIKE, 3, Hint.BALL, 0)), true),
                Arguments.arguments(new Score(Map.of(Hint.STRIKE, 2, Hint.BALL, 1)), false),
                Arguments.arguments(new Score(Map.of(Hint.STRIKE, 0, Hint.BALL, 3)), false)
        );
    }

    static Stream<Arguments> toStringParametersProvider() {
        return Stream.of(
                Arguments.arguments(new Score(Map.of(Hint.STRIKE, 3, Hint.BALL, 0)), "3스트라이크"),
                Arguments.arguments(new Score(Map.of(Hint.STRIKE, 2, Hint.BALL, 1)), "1볼 2스트라이크"),
                Arguments.arguments(new Score(Map.of(Hint.STRIKE, 0, Hint.BALL, 3)), "3볼")
        );
    }
}
