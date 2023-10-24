package baseball.domain;

import static baseball.util.TestDataUtil.createGuessResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.dto.GuessResult;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

    @DisplayName("3자리 1-9 사이의 숫자가 입력되면 Balls가 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "542", "193"})
    void from(String givenValue) {
        assertDoesNotThrow(() -> Balls.from(givenValue));
    }

    @DisplayName("숫자가 아닌 문자, 3자리가 아닌 숫자, 중복된 숫자, 0을 포함한 숫자가 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aㅇ1", "$", "", "1", "12", "112", "902"})
    void invalid_from(String givenValue) {
        assertThatThrownBy(() -> Balls.from(givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 Balls와 비교해 GuessResult를 생성한다")
    @ParameterizedTest
    @MethodSource("guessArgumentsProvider")
    void guess(Balls computerBalls, Balls inputBalls, GuessResult expectedResult) {
        GuessResult guessResult = computerBalls.guess(inputBalls);

        assertThat(guessResult.count(BallStatus.STRIKE)).isEqualTo(expectedResult.count(BallStatus.STRIKE));
        assertThat(guessResult.count(BallStatus.BALL)).isEqualTo(expectedResult.count(BallStatus.BALL));
    }

    static Stream<Arguments> guessArgumentsProvider() {
        return Stream.of(
                Arguments.of(Balls.from("123"), Balls.from("456"), createGuessResult(0, 0)),
                Arguments.of(Balls.from("123"), Balls.from("157"), createGuessResult(1, 0)),
                Arguments.of(Balls.from("915"), Balls.from("583"), createGuessResult(0, 1)),
                Arguments.of(Balls.from("915"), Balls.from("915"), createGuessResult(3, 0)),
                Arguments.of(Balls.from("362"), Balls.from("236"), createGuessResult(0, 3)),
                Arguments.of(Balls.from("362"), Balls.from("263"), createGuessResult(1, 2))
        );
    }

}
