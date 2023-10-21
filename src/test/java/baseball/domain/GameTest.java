package baseball.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameTest {

    private Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    private static Stream<Arguments> provideStrikeTestCases() {
        return Stream.of(Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(4, 5, 6), List.of(4, 9, 6), 2),
                Arguments.of(List.of(9, 8, 3), List.of(4, 8, 7), 1),
                Arguments.of(List.of(3, 6, 9), List.of(8, 3, 2), 0));
    }

    @ParameterizedTest
    @DisplayName("스트라이크 테스트")
    @MethodSource("provideStrikeTestCases")
    public void compareNumbersTest(List<Integer> computerNumber, List<Integer> playerNumber, int expectedStrikes) {
        Assertions.assertThat(game.countStrikes(computerNumber, playerNumber)).isEqualTo(expectedStrikes);
    }

    private static Stream<Arguments> provideBallTestCases() {
        return Stream.of(Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 0),
                Arguments.of(List.of(4, 5, 9), List.of(4, 9, 6), 1),
                Arguments.of(List.of(9, 8, 3), List.of(3, 2, 9), 2),
                Arguments.of(List.of(3, 6, 9), List.of(6, 9, 3), 3));
    }

    @ParameterizedTest
    @DisplayName("볼 테스트")
    @MethodSource("provideBallTestCases")
    public void compareNumbersTest2(List<Integer> computerNumber, List<Integer> playerNumber, int expectedBalls) {
        Assertions.assertThat(game.countBalls(computerNumber, playerNumber)).isEqualTo(expectedBalls);
    }

}