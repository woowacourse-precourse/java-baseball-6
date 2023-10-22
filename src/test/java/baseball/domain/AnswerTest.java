package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AnswerTest {

    @DisplayName("Answer의 match()를 호출하면 입력값에 맞는 Score를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideMatchTestArguments")
    void matchTest(Answer answer, String input, Score expectedScore) {
        assertThat(answer.match(input)).isEqualTo(expectedScore);
    }

    static Stream<Arguments> provideMatchTestArguments() {
        return Stream.of(
                arguments(new Answer(new Numbers(List.of(1, 2, 3))), "321", new Score(new Ball(2), new Strike(1))),
                arguments(new Answer(new Numbers(List.of(4, 5, 6))), "564", new Score(new Ball(3), new Strike(0))),
                arguments(new Answer(new Numbers(List.of(4, 5, 6))), "321", new Score(new Ball(0), new Strike(0))),
                arguments(new Answer(new Numbers(List.of(3, 2, 1))), "321", new Score(new Ball(0), new Strike(3)))
        );
    }
}
