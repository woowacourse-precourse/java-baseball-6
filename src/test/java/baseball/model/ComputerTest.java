package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.StubNumberGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = Computer.createWithGenerator(new StubNumberGenerator("123"));
    }

    @CsvSource({"1, 2, 3, 3", "1, 3, 2,1 ", "5, 6, 7, 0", "1, 2, 5, 2"})
    @ParameterizedTest
    void 스트라이크갯수를_반환한다(int firstNum, int secondNum, int thirdNum, int expected) {
        // given
        List<Integer> inputNumbers = Arrays.asList(firstNum, secondNum, thirdNum);

        // when
        int result = computer.getStrikeCount(inputNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @CsvSource({"1, 2, 3, 0", "1, 3, 2, 2 ", "5, 6, 7, 0", "9, 2, 1, 1"})
    @ParameterizedTest
    void 볼갯수를_반환한다(int firstNum, int secondNum, int thirdNum, int expected) {
        // given
        List<Integer> inputNumbers = Arrays.asList(firstNum, secondNum, thirdNum);

        // when
        int result = computer.getBallCount(inputNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 쓰리_스트라이크인지_확인한다() {
        // given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);

        // when
        boolean isThreeStrikes = computer.isThreeStrikes(inputNumbers);

        // then
        assertThat(isThreeStrikes).isTrue();
    }
}
