package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.fixture.ComputerFixture;
import baseball.fixture.UserNumbersFixture;
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
        computer = ComputerFixture.createComputer("123");
    }

    @CsvSource({"123, 3", "132,1 ", "567, 0", "125, 2"})
    @ParameterizedTest
    void 스트라이크갯수를_비교하여_반환한다(String input, int expected) {
        // given
        UserNumbers userNumbers = UserNumbersFixture.createUserNumbers(input);
        List<Number> selectedNumbers = userNumbers.getSelectedNumbers();

        // when
        int result = computer.countStrikes(selectedNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @CsvSource({"123, 0", "132, 2 ", "567, 0", "921, 1"})
    @ParameterizedTest
    void 볼갯수를_비교하여_반환한다(String input, int expected) {
        // given
        UserNumbers userNumbers = UserNumbersFixture.createUserNumbers(input);
        List<Number> selectedNumbers = userNumbers.getSelectedNumbers();

        // when
        int result = computer.countBalls(selectedNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 쓰리_스트라이크인지_확인한다() {
        // given
        String input = "123";
        UserNumbers userNumbers = UserNumbersFixture.createUserNumbers(input);
        List<Number> selectedNumbers = userNumbers.getSelectedNumbers();

        // when
        boolean isThreeStrikes = computer.isThreeStrikes(selectedNumbers);

        // then
        assertThat(isThreeStrikes).isTrue();
    }
}
