package baseball.domain;

import static baseball.util.TestDataUtil.createGuessResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerBallsTest {

    @DisplayName("주어진 BallNumbersGenerateStrategy에 의해 Balls가 생성된다")
    @ParameterizedTest
    @MethodSource("fromArgumentsProvider")
    void from(List<Integer> ballNumbers) {
        ComputerBalls computerBalls = ComputerBalls.from(((startInclusive, endInclusive, count) -> ballNumbers));

        List<Ball> expectedBalls = ballNumbers.stream()
                .map(Ball::from)
                .toList();
        assertThat(computerBalls.balls()).isEqualTo(expectedBalls);
    }

    static Stream<Arguments> fromArgumentsProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(4, 1, 5)),
                Arguments.of(List.of(9, 5, 8))
        );
    }

    @DisplayName("주어진 Balls와 비교해 GuessResult를 생성한다")
    @ParameterizedTest
    @MethodSource("guessArgumentsProvider")
    void guess(ComputerBalls computerBalls, Balls userBalls, GuessResult expectedResult) {
        GuessResult guessResult = computerBalls.guess(userBalls);

        assertThat(guessResult.count(BallStatus.STRIKE)).isEqualTo(expectedResult.count(BallStatus.STRIKE));
        assertThat(guessResult.count(BallStatus.BALL)).isEqualTo(expectedResult.count(BallStatus.BALL));
    }

    static Stream<Arguments> guessArgumentsProvider() {
        return Stream.of(
                Arguments.of(createComputerBalls(1, 2, 3), UserBalls.from("456"),
                        createGuessResult(0, 0)),
                Arguments.of(createComputerBalls(1, 2, 3), UserBalls.from("157"),
                        createGuessResult(1, 0)),
                Arguments.of(createComputerBalls(9, 1, 5), UserBalls.from("583"),
                        createGuessResult(0, 1)),
                Arguments.of(createComputerBalls(9, 1, 5), UserBalls.from("915"),
                        createGuessResult(3, 0)),
                Arguments.of(createComputerBalls(3, 6, 2), UserBalls.from("236"),
                        createGuessResult(0, 3)),
                Arguments.of(createComputerBalls(3, 6, 2), UserBalls.from("263"),
                        createGuessResult(1, 2))
        );
    }

    @DisplayName("불변의 Ball 리스트가 반환된다")
    @Test
    void balls() {
        ComputerBalls computerBalls = createComputerBalls(1, 2, 3);
        List<Ball> balls = computerBalls.balls();

        assertThatThrownBy(() -> balls.add(0, Ball.from("4")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("주어진 index의 Ball이 반환된다")
    @Test
    void ballAt() {
        ComputerBalls computerBalls = createComputerBalls(1, 2, 3);
        assertThat(computerBalls.ballAt(0)).isEqualTo(Ball.from("1"));
    }

    private static ComputerBalls createComputerBalls(Integer... ballNumbers) {
        return ComputerBalls.from(((startInclusive, endInclusive, count) -> List.of(ballNumbers)));
    }

}
