package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballNumbersTest {

    private static BaseballNumbers setBaseballNumbers(int value, int value1, int value2) {
        return new BaseballNumbers(
                List.of(new BaseballNumber(value), new BaseballNumber(value1), new BaseballNumber(value2)));
    }

    @ParameterizedTest
    @MethodSource("provideConvertToBaseballNumbersTestArguments")
    void convertToBaseballNumbersTest(String input, BaseballNumbers baseballNumbers) {
        BaseballNumbers convertedBaseballNumbers = BaseballNumbers.convertToBaseballNumbers(input);
        assertThat(convertedBaseballNumbers).isEqualTo(baseballNumbers);
    }

    static Stream<Arguments> provideConvertToBaseballNumbersTestArguments() {
        return Stream.of(
                arguments("123", setBaseballNumbers(1, 2, 3)),
                arguments("456", setBaseballNumbers(4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculateScoreTestArguments")
    void calculateScoreTest(BaseballNumbers computer, BaseballNumbers player, String expectedScoreToString) {
        Score score = computer.calculateScore(player);
        assertThat(score.toString()).isEqualTo(expectedScoreToString);
    }

    static Stream<Arguments> provideCalculateScoreTestArguments() {
        return Stream.of(
                arguments(setBaseballNumbers(1, 3, 5), setBaseballNumbers(2, 4, 6), "낫싱"),
                arguments(setBaseballNumbers(1, 3, 5), setBaseballNumbers(1, 3, 5), "3스트라이크"),
                arguments(setBaseballNumbers(5, 8, 9), setBaseballNumbers(5, 9, 7), "1볼 1스트라이크"),
                arguments(setBaseballNumbers(5, 8, 9), setBaseballNumbers(5, 8, 9), "3스트라이크")
        );
    }
}
