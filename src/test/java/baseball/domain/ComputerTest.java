package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ComputerTest {

    @DisplayName("컴퓨터가 생성한 숫자와 사용자가 입력한 숫자를 비교하여 Score를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideGetScoreTestArguments")
    void getScoreTest(BaseballNumbers inputBaseballNumbers, Score expectedScore) {
        Computer computer = new Computer(new FixedBaseballNumbersGenerator());
        Score score = computer.calculateScore(inputBaseballNumbers);
        assertThat(score.getBallCount()).isEqualTo(expectedScore.getBallCount());
        assertThat(score.getStrikeCount()).isEqualTo(expectedScore.getStrikeCount());
    }

    static Stream<Arguments> provideGetScoreTestArguments() {
        return Stream.of(
                arguments(setInputBaseballNumbers(1, 2, 3), setExpectedScore(1, 1)),
                arguments(setInputBaseballNumbers(1, 4, 5), setExpectedScore(1, 0)),
                arguments(setInputBaseballNumbers(6, 7, 1), setExpectedScore(2, 0)),
                arguments(setInputBaseballNumbers(2, 1, 6), setExpectedScore(0, 1)),
                arguments(setInputBaseballNumbers(7, 1, 3), setExpectedScore(0, 3))
        );
    }

    private static BaseballNumbers setInputBaseballNumbers(int x, int y, int z) {
        return new BaseballNumbers(Stream.of(x, y, z).map(BaseballNumber::new).toList());
    }

    private static Score setExpectedScore(int ball, int strike) {
        return new Score(new Ball(ball), new Strike(strike));
    }
}
