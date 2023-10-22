package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.helper.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    void init() {
        computer = Computer.createDefault(new TestNumberGenerator(List.of(1, 5, 9)));
    }

    @CsvSource({"1,2,3,1","4,5,6,1","7,8,9,1", "1,5,9,3"})
    @ParameterizedTest
    void 스트라이크_수를_계산한다(int firstNumber, int secondNumber, int thirdNumber, int expected) {
        // given
        List<Integer> guessNumbers = List.of(firstNumber, secondNumber, thirdNumber);

        // when
        int strikeCount = computer.countStrikes(guessNumbers);

        // then
        assertThat(strikeCount).isEqualTo(expected);
    }

    // 볼 개수 계산
    @Test
    void 볼_수를_계산한다() {
        // given
        List<Integer> guessNumbers = List.of(1, 5, 9);

        // when
        boolean result = computer.isGameOver(guessNumbers);

        // then
        assertThat(result).isTrue();
    }

    // 게임이 끝났는지 확인
    @CsvSource({"3,2,1,1","6,5,4,0","9,8,7,1", "9,5,1,2"})
    @ParameterizedTest
    void 모든_숫자를_맞추면_true를_반환한다(int firstNumber, int secondNumber, int thirdNumber, int expected) {
        // given
        List<Integer> guessNumbers = List.of(firstNumber, secondNumber, thirdNumber);

        // when
        int ballCount = computer.countBalls(guessNumbers);

        // then
        assertThat(ballCount).isEqualTo(expected);
    }
}

