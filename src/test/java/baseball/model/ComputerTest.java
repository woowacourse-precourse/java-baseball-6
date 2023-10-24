package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.helper.TestNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = Computer.createWith(new TestNumberGenerator(List.of(1, 5, 9)));
    }

    @MethodSource("guessNumbersAndResultProvider")
    @ParameterizedTest
    void 볼과_스트라이크의_수를_계산한다(List<Integer> guessNumbers, int expectedBalls, int expectedStrikes) {
        // when
        int ballCount = computer.countBalls(guessNumbers);
        int strikeCount = computer.countStrikes(guessNumbers);

        // then
        assertThat(ballCount).isEqualTo(expectedBalls);
        assertThat(strikeCount).isEqualTo(expectedStrikes);
    }

    private static Stream<Arguments> guessNumbersAndResultProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 0, 1),
                Arguments.of(List.of(4, 5, 6), 0, 1),
                Arguments.of(List.of(7, 8, 9), 0, 1),
                Arguments.of(List.of(5, 1, 9), 2, 1),
                Arguments.of(List.of(1, 5, 9), 0, 3)
        );
    }

    @CsvSource({"3,2,1,false", "6,5,4,false", "1,5,9,true"})
    @ParameterizedTest
    void 모든_숫자를_맞추면_true를_반환한다(int firstNumber, int secondNumber, int thirdNumber, boolean expected) {
        // given
        List<Integer> guessNumbers = List.of(firstNumber, secondNumber, thirdNumber);

        // when
        boolean result = computer.isGameOver(guessNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }
}

