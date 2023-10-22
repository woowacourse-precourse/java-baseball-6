package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ScoreTest {

    @DisplayName("Score 생성시 볼과 스트라이크의 갯수가 0이상 3이하면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @MethodSource("provideCreateSuccessTestArguments")
    void createSuccessTest(int ball, int strike) {
        assertThatCode(() -> new Score(new Ball(ball), new Strike(strike)))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> provideCreateSuccessTestArguments() {
        return Stream.of(
                arguments(0, 1),
                arguments(0, 2),
                arguments(0, 3),
                arguments(1, 0),
                arguments(2, 0),
                arguments(3, 0),
                arguments(1, 1),
                arguments(1, 2),
                arguments(2, 1)
        );
    }

    @DisplayName("Score 생성시 볼과 스트라이크의 갯수가 0이상 3이하가 아니면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideCreateFailTestArguments")
    void createFailTest(int ball, int strike) {
        assertThatCode(() -> new Score(new Ball(ball), new Strike(strike)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼과 스트라이크 갯수의 합은 0 이상 3 이하여야 합니다.");
    }

    static Stream<Arguments> provideCreateFailTestArguments() {
        return Stream.of(
                arguments(3, 1),
                arguments(2, 2),
                arguments(1, 3),
                arguments(3, 3)
        );
    }

    @DisplayName("Score의 isStrikeOut()을 호출하면 Strike가 3인지 반환한다.")
    @ParameterizedTest
    @MethodSource("provideIsStrikeOutTestArguments")
    void strikeOutTest(Score score, boolean expected) {
        assertThat(score.isStrikeOut()).isEqualTo(expected);
    }

    static Stream<Arguments> provideIsStrikeOutTestArguments() {
        return Stream.of(
                arguments(new Score(new Ball(0), new Strike(3)), true),
                arguments(new Score(new Ball(1), new Strike(1)), false)
        );
    }
}
