package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballGameTest {

    @DisplayName("새로운 게임을 시작하면 주어진 BallNumbersGenerateStrategy에 의해 computerBalls가 생성된다")
    @ParameterizedTest
    @MethodSource("newGameArgumentsProvider")
    void newGame(List<Integer> ballNumbers) {
        BaseballGame baseballGame = BaseballGame.newGame((startInclusive, endInclusive, count) -> ballNumbers);
        ComputerBalls computerBalls = baseballGame.computerBalls();

        List<Ball> expectedBalls = ballNumbers.stream()
                .map(Ball::from)
                .toList();
        assertThat(computerBalls.balls()).isEqualTo(expectedBalls);
    }

    static Stream<Arguments> newGameArgumentsProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(4, 1, 5)),
                Arguments.of(List.of(9, 5, 8))
        );
    }

}
