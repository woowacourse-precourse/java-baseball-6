package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ComputerTest {

    @DisplayName("컴퓨터가 생성한 숫자와 사용자가 입력한 숫자를 비교하여 Score를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideGetScoreTestArguments")
    void getScoreTest(String input, Score expectedScore) {
        Computer computer = new Computer(new FixedAnswerGenerator());
        Score score = computer.getScore(input);
        assertThat(score).isEqualTo(expectedScore);
    }

    static Stream<Arguments> provideGetScoreTestArguments() {
        return Stream.of(
                arguments("123", new Score(1, 1)),
                arguments("145", new Score(1, 0)),
                arguments("671", new Score(2, 0)),
                arguments("216", new Score(0, 1)),
                arguments("713", new Score(0, 3))
        );
    }
}
