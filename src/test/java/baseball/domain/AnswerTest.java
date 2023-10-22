package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AnswerTest {

    @DisplayName("Answer의 match()를 호출하면 입력값에 맞는 Score를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideMatchTestArguments")
    void matchTest(Answer answer, BaseballNumbers inputBaseballNumbers, Score expectedScore) {
        assertThat(answer.match(inputBaseballNumbers)).isEqualTo(expectedScore);
    }

    static Stream<Arguments> provideMatchTestArguments() {
        return Stream.of(
                arguments(setAnswer(1, 2, 3), setInputBaseballNumbers(3, 2, 1), setExpectedScore(2, 1)),
                arguments(setAnswer(4, 5, 6), setInputBaseballNumbers(5, 6, 4), setExpectedScore(3, 0)),
                arguments(setAnswer(4, 5, 6), setInputBaseballNumbers(3, 2, 1), setExpectedScore(0, 0)),
                arguments(setAnswer(3, 2, 1), setInputBaseballNumbers(3, 2, 1), setExpectedScore(0, 3))
        );
    }

    private static Score setExpectedScore(int ball, int strike) {
        return new Score(new Ball(ball), new Strike(strike));
    }

    private static BaseballNumbers setInputBaseballNumbers(int x, int x1, int x2) {
        return new BaseballNumbers(Stream.of(x, x1, x2).map(BaseballNumber::new).toList());
    }

    private static Answer setAnswer(int x, int x1, int x2) {
        return new Answer(setInputBaseballNumbers(x, x1, x2));
    }
}
