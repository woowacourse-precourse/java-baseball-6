package baseball.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setup() {

        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("사용자는 랜덤한 1-9 사이의 랜덤한 세 개의 숫자를 생성할 수 있다.")
    void generateThreeNumberTest() {

        // when
        List<Integer> numbers = randomNumberGenerator.generateRandomNumber();

        // then
        assertAll(
                () -> assertThat(numbers).hasSize(3),
                () -> {
                    assertNotNull(numbers);
                    numbers.forEach(number -> assertThat(number).isBetween(1, 9));
                }
        );
    }

    @Test
    @DisplayName("사용자는 중복되지 않는 3개의 숫자를 생성할 수 있다.")
    void generateNotDuplicatedTest() {

        // when
        List<Integer> numbers = randomNumberGenerator.generateRandomNumber();

        // then
        assertThat(numbers.stream().distinct().count()).isEqualTo(3);
    }
}
