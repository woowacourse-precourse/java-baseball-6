package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("1부터 9사이의 숫자만 생성되는지 확인")
    void generateNumberBetween1And9() {
        for (int i = 0; i < 10000; i++) {
            int number = RandomGenerator.generateNumber();
            assertThat(number).isBetween(1, 9);
        }
    }

}