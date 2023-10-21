package baseball.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @DisplayName("N개의 중복되지 않는 랜덤한 숫자를 생성할 수 있다.")
    @RepeatedTest(100)
    void generateRandomNumbers() {
        // given
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers(3);

        // when
        int firstNumber = randomNumbers.get(0);
        int secondNumber = randomNumbers.get(1);
        int thirdNumber = randomNumbers.get(2);

        // then
        assertAll(
                () -> assertThat(firstNumber).isNotEqualTo(secondNumber),
                () -> assertThat(firstNumber).isNotEqualTo(thirdNumber),
                () -> assertThat(secondNumber).isNotEqualTo(thirdNumber)
        );
    }
}