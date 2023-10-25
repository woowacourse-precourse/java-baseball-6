package baseball.service;

import baseball.model.GameNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCalculatorTest {

    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @DisplayName("같은 수 같은 자리면 스트라이크")
    @ParameterizedTest(name = "{index} {displayName} message={0}, {1}, {2}")
    @MethodSource("checkStrikeParametersProvider")
    void checkCalculateStrike(GameNumbers computer, GameNumbers player, Integer strikeCount) {
        assertThat(scoreCalculator.calculateStrike(computer, player))
                .isEqualTo(strikeCount);
    }

    @DisplayName("같은 수 다른 자리면 볼")
    @ParameterizedTest(name = "{index} {displayName} message={0}, {1}, {2}")
    @MethodSource("checkBallParametersProvider")
    void checkCalculateBall(GameNumbers computer, GameNumbers player, Integer ballCount) {
        assertThat(scoreCalculator.calculateBall(computer, player))
                .isEqualTo(ballCount);
    }

    static Stream<Arguments> checkStrikeParametersProvider() {
        return Stream.of(
                Arguments.arguments(GameNumbers.of("123"), GameNumbers.of("213"), 1),
                Arguments.arguments(GameNumbers.of("456"), GameNumbers.of("456"), 3),
                Arguments.arguments(GameNumbers.of("972"), GameNumbers.of("218"), 0),
                Arguments.arguments(GameNumbers.of("538"), GameNumbers.of("138"), 2)
        );
    }

    static Stream<Arguments> checkBallParametersProvider() {
        return Stream.of(
                Arguments.arguments(GameNumbers.of("123"), GameNumbers.of("213"), 2),
                Arguments.arguments(GameNumbers.of("456"), GameNumbers.of("456"), 0),
                Arguments.arguments(GameNumbers.of("972"), GameNumbers.of("218"), 1),
                Arguments.arguments(GameNumbers.of("538"), GameNumbers.of("385"), 3)
        );
    }
}
