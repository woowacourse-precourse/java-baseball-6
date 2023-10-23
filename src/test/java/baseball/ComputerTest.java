package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    public void setUp() {
        computer = new Computer();
    }

    @Test
    public void 숫자랜덤생성_크기3_범위_중복없는지확인() {
        // given
        List<Integer> randomNumbers = computer.generateRandomNumbers();

        // when & then
        assertThat(randomNumbers.size()).isEqualTo(3);
        for (int number : randomNumbers) {
            assertThat(number >= 1 && number <= 9);
        }
        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = i + 1; j < randomNumbers.size(); j++) {
                assertThat(randomNumbers.get(i)).isNotEqualTo(randomNumbers.get(j));
            }
        }
    }

    @Test
    public void 게임결과_계산() {
        // given
        List<Integer> targetNumbers = Arrays.asList(1, 2, 3);

        // when
        List<Integer> userGuess = Arrays.asList(3, 2, 6);
        GameResult result = computer.calculateGameResult(targetNumbers, userGuess);

        // then
        assertEquals(1, result.strikes());
        assertEquals(1, result.balls());
    }

}