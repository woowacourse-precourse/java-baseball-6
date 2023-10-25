package baseball.domain;

import static baseball.util.TestDataUtil.createGuessResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.dto.GuessResult;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComputerBallsTest {

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
                Arguments.of(createComputerBalls("123"), UserBalls.from("456"),
                        createGuessResult(0, 0)),
                Arguments.of(createComputerBalls("123"), UserBalls.from("157"),
                        createGuessResult(1, 0)),
                Arguments.of(createComputerBalls("915"), UserBalls.from("583"),
                        createGuessResult(0, 1)),
                Arguments.of(createComputerBalls("915"), UserBalls.from("915"),
                        createGuessResult(3, 0)),
                Arguments.of(createComputerBalls("362"), UserBalls.from("236"),
                        createGuessResult(0, 3)),
                Arguments.of(createComputerBalls("362"), UserBalls.from("263"),
                        createGuessResult(1, 2))
        );
    }

    @DisplayName("불변의 Ball 리스트가 반환된다")
    @Test
    void balls() {
        ComputerBalls computerBalls = createComputerBalls("123");
        List<Ball> balls = computerBalls.balls();

        assertThatThrownBy(() -> balls.add(0, Ball.from("4")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("주어진 index의 Ball이 반환된다")
    @Test
    void ballAt() {
        ComputerBalls computerBalls = createComputerBalls("123");
        assertThat(computerBalls.ballAt(0)).isEqualTo(Ball.from("1"));
    }

    private static ComputerBalls createComputerBalls(String ballNumbers) {
        return ComputerBalls.from(((startInclusive, endInclusive, count) -> ballNumbers));
    }

}
