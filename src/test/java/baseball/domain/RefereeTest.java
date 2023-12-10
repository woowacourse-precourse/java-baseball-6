package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,3,0", "1,2,4,2,0", "3,2,1,1,2"})
    void compare(int num1, int num2, int num3, int strike, int ball) {
        List<Integer> expected = Arrays.asList(strike, ball);
        List<Integer> actual = referee.compare(ANSWER, Arrays.asList(num1, num2, num3));
        assertThat(actual).isEqualTo(expected);
    }
}