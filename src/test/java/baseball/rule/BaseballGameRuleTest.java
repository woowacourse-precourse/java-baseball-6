package baseball.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.computer.Computer;
import baseball.domain.number.GameNumber;
import baseball.domain.result.Result;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballGameRuleTest {

    @MethodSource("provideNumbersAndResult")
    @ParameterizedTest
    void check(List<Integer> userNumbers, List<Integer> computerNumbers, Integer strike, Integer ball) {
        Rule rule = new BaseballGameRule();

        Result result = rule.check(new GameNumber(userNumbers), new Computer(computerNumbers));

        assertThat(result.getStrike()).isEqualTo(strike);
        assertThat(result.getBall()).isEqualTo(ball);
    }

    private static Stream<Arguments> provideNumbersAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3, 0),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0),
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(2, 3, 5), 1, 1),
                Arguments.of(Arrays.asList(9, 4, 7), Arrays.asList(4, 5, 6), 0, 1)
        );
    }
}
