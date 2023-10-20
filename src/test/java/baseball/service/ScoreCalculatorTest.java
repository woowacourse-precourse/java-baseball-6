package baseball.service;

import baseball.model.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {

    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @DisplayName("같은 수 같은 자리면 스트라이크")
    @ParameterizedTest(name = "{index} {displayName} message={0}, {1}, {2}")
    @MethodSource("checkStrikeParametersProvider")
    void checkCalculateStrike(GameNumber computer, GameNumber player, Integer strikeCount) {
        assertThat(scoreCalculator.calculateStrike(computer, player)).isEqualTo(strikeCount);
    }

    @DisplayName("같은 수 다른 자리면 볼")
    @ParameterizedTest(name = "{index} {displayName} message={0}, {1}, {2}")
    @MethodSource("checkBallParametersProvider")
    void checkCalculateBall(GameNumber computer, GameNumber player, Integer ballCount) {
        assertThat(scoreCalculator.calculateBall(computer, player)).isEqualTo(ballCount);
    }

    static Stream<Arguments> checkStrikeParametersProvider() {
        return Stream.of(
                Arguments.arguments(GameNumber.of(List.of(1, 2, 3)), GameNumber.of(List.of(2, 1, 3)), 1),
                Arguments.arguments(GameNumber.of(List.of(4, 5, 6)), GameNumber.of(List.of(4, 5, 6)), 3),
                Arguments.arguments(GameNumber.of(List.of(9, 7, 2)), GameNumber.of(List.of(2, 1, 8)), 0),
                Arguments.arguments(GameNumber.of(List.of(5, 3, 8)), GameNumber.of(List.of(1, 3, 8)), 2)
        );
    }

    static Stream<Arguments> checkBallParametersProvider() {
        return Stream.of(
                Arguments.arguments(GameNumber.of(List.of(1, 2, 3)), GameNumber.of(List.of(2, 1, 3)), 2),
                Arguments.arguments(GameNumber.of(List.of(4, 5, 6)), GameNumber.of(List.of(4, 5, 6)), 0),
                Arguments.arguments(GameNumber.of(List.of(9, 7, 2)), GameNumber.of(List.of(2, 1, 8)), 1),
                Arguments.arguments(GameNumber.of(List.of(5, 3, 8)), GameNumber.of(List.of(3, 8, 5)), 3)
        );
    }
}