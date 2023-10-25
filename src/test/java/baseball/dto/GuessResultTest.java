package baseball.dto;

import static baseball.util.TestDataUtil.createGuessResult;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BallStatus;
import baseball.domain.GuessResult;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GuessResultTest {

    @DisplayName("최초 생성 시 빈 상태로 생성된다")
    @Test
    void empty() {
        GuessResult guessResult = GuessResult.empty();

        assertThat(guessResult.count(BallStatus.STRIKE)).isZero();
        assertThat(guessResult.count(BallStatus.BALL)).isZero();
    }

    @DisplayName("특정 BallStatus에 대한 값이 없는 경우 0이 반환된다")
    @Test
    void count() {
        GuessResult guessResult = GuessResult.empty();

        assertThat(guessResult.count(BallStatus.STRIKE)).isZero();
        assertThat(guessResult.count(BallStatus.BALL)).isZero();
    }

    @DisplayName("add시 주어진 BallStatus에 대한 count 값이 1 증가된 인스턴스를 반환한다")
    @Test
    void add() {
        GuessResult guessResult = GuessResult.empty();

        guessResult = guessResult.add(BallStatus.STRIKE);
        guessResult = guessResult.add(BallStatus.STRIKE);
        guessResult = guessResult.add(BallStatus.BALL);

        assertThat(guessResult.count(BallStatus.STRIKE)).isEqualTo(2);
        assertThat(guessResult.count(BallStatus.BALL)).isEqualTo(1);
    }

    @DisplayName("add시 새로운 값을 반환하며 기존 값에는 영향을 주지 않는다")
    @Test
    void immutablyAdd() {
        GuessResult guessResult = GuessResult.empty();
        GuessResult newGuessResult = guessResult.add(BallStatus.STRIKE);

        assertThat(newGuessResult).isNotSameAs(guessResult);
        assertThat(guessResult.count(BallStatus.STRIKE)).isZero();
        assertThat(newGuessResult.count(BallStatus.STRIKE)).isOne();
    }

    @DisplayName("STRIKE가 3개 존재하는 경우에만 true가 반환된다")
    @ParameterizedTest
    @MethodSource("correctArgumentsProvider")
    void correct(GuessResult guessResult, boolean expected) {
        assertThat(guessResult.correct()).isEqualTo(expected);
    }

    static Stream<Arguments> correctArgumentsProvider() {
        return Stream.of(
                Arguments.of(createGuessResult(0, 0), false),
                Arguments.of(createGuessResult(1, 0), false),
                Arguments.of(createGuessResult(1, 1), false),
                Arguments.of(createGuessResult(2, 1), false),
                Arguments.of(createGuessResult(3, 0), true),
                Arguments.of(createGuessResult(4, 0), false)
        );
    }
}
